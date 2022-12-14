package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {

	private CustomerInfo customerInfo;
	private Long orderNum;
	private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();
	private String message;

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public List<CartLineInfo> getCartLines() {
		return cartLines;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private CartLineInfo findLineById(Long id) {
		for (CartLineInfo line : this.cartLines) {
			if (line.getProductInfo().getProductId().equals(id)) {
				return line;
			}
		}
		return null;
	}

	public void addProduct(ProductInfo productInfo, Long quantity, Long currentQuantity) {
		CartLineInfo line = this.findLineById(productInfo.getProductId());
		if (line == null) {
			line = new CartLineInfo();
			line.setQuantity(0);
			line.setProductInfo(productInfo);
			this.cartLines.add(line);
		}
		long newQuantity = line.getQuantity() + quantity < currentQuantity ?
				line.getQuantity() + quantity : currentQuantity;
		if (newQuantity <= 0) {
			this.cartLines.remove(line);
		} else {
			line.setQuantity(newQuantity);
		}
	}

	public void updateProduct(Long id, Long quantity) {
		CartLineInfo line = this.findLineById(id);
		if (line != null) {
			if (quantity <= 0) {
				this.cartLines.remove(line);
			} else {
				line.setQuantity(quantity);
			}
		}
	}

	public void removeProduct(ProductInfo productInfo) {
		CartLineInfo line = this.findLineById(productInfo.getProductId());
		if (line != null) {
			this.cartLines.remove(line);
		}
	}

	public boolean isEmpty() {
		return this.cartLines.isEmpty();
	}

	public int getQuantityTotal() {
		int quantity = 0;
		for (CartLineInfo line : this.cartLines) {
			quantity += line.getQuantity();
		}
		return quantity;
	}

	public long getAmountTotal() {
		long total = 0;
		for (CartLineInfo line : this.cartLines) {
			total += line.getAmount();
		}
		return total;
	}

	public void updateQuantity(CartInfo cartForm) {
		if (cartForm != null) {
			List<CartLineInfo> lines = cartForm.getCartLines();
			for (CartLineInfo line : lines) {
				this.updateProduct(line.getProductInfo().getProductId(), line.getQuantity());
			}
		}
	}
}
