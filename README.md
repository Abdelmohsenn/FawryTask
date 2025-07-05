# Fawry's Internship Task

## note: 
**All exceptions have been grouped in *ExceptionGrouped* folder with CustomNames**
**For the expiry date, there are two instantiation of dates. one with +3 to the "Now" date (3 Days left to expire), and one with -2 from the "Now" Date (Expired for 2 days)**
**Testing Java file is Called *Demo***

## In-Code Samples:
**Sample Test Data Overview**
The following test setup demonstrates various scenarios using different product types and customer profiles:
**Products:**

* 🧀 *Cheese*
* 📺 *TV*
* 📱 *Mobile*
* 🎟️ *MobileScratchCard*
* 🍪 *Biscuit*

**Customers:**
- richCustomer: Has a large balance and can afford any product.
- poorCustomer: Has minimal balance, likely to trigger InsufficientBalanceException.
- emptyCartCustomer: Starts with an empty cart, used to test edge cases like checking out an empty cart.
These samples are used to simulate normal purchases, expired product handling, insufficient funds, and empty cart scenarios.

<img width="780" alt="Screenshot 2025-07-05 at 5 30 31 PM" src="https://github.com/user-attachments/assets/376fb6d5-56a7-47f4-a58b-37300b60dd28" />

## 1. Successful Checkout

Input: Cart contains only available & non-expired products, customer balance >= total.
Expected Result: 
  1. Stock decremented for the chosen product,
  2. Customer Balance deducted.
  3. Shipment and receipt printed.
     

### 1st Case Code Example:
<img width="534" alt="Screenshot 2025-07-05 at 5 31 50 PM" src="https://github.com/user-attachments/assets/9c1f08ed-7f9e-403b-872f-0988d74848e6" />

### 1st Case Console Output:
<img width="381" alt="Screenshot 2025-07-05 at 5 39 24 PM" src="https://github.com/user-attachments/assets/b38d4bc8-8eac-418f-9475-4d7606fbc6de" />


## 2. Out of Stock


Input: Cart contains a product with quantity > available stock.
Expected Result:
OutOfStockException thrown.
No changes to stock or balance.
No shipment/receipt printed.

### 2nd Case Code Example:
<img width="604" alt="Screenshot 2025-07-05 at 5 32 33 PM" src="https://github.com/user-attachments/assets/3409873e-3f32-42c4-9075-537280637e87" />

### 2nd Case Console Output:

<img width="604" alt="Screenshot 2025-07-05 at 5 34 12 PM" src="https://github.com/user-attachments/assets/c200e336-79c9-4ddc-b15f-540d751ba759" />

## 3. Expired Product

### 3rd Case Code Example:
<img width="604" alt="Screenshot 2025-07-05 at 5 35 42 PM" src="https://github.com/user-attachments/assets/e0e3aa44-a6d6-4d0a-9bdc-69471c772ab4" />

### 3rd Case Console Output:

<img width="759" alt="Screenshot 2025-07-05 at 5 35 58 PM" src="https://github.com/user-attachments/assets/baca3f91-2365-426d-88eb-4312a91021b2" />

Input: Cart contains at least one expired product.
Expected Result:
All expired product names listed in error.
No changes to stock or balance.
No shipment/receipt printed.

## 4. Insufficient Balance

### 4th Case Code Example:
<img width="653" alt="Screenshot 2025-07-05 at 5 36 34 PM" src="https://github.com/user-attachments/assets/a6b98e07-e450-4f59-980c-dc969040e4bb" />

### 4th Case Console Output:
<img width="824" alt="Screenshot 2025-07-05 at 5 36 52 PM" src="https://github.com/user-attachments/assets/3bcc4d32-c11d-4f5c-ae4f-df999ebc8d0e" />


Input: Customer's balance is less than the total (subtotal + shipping).
Expected Result:
InsufficientBalanceException thrown.
No changes to stock or balance.
No shipment/receipt printed.

## 5. Empty Cart

### 5th Case Code Example:

<img width="610" alt="Screenshot 2025-07-05 at 5 37 41 PM" src="https://github.com/user-attachments/assets/0e7a056e-c8a9-4af7-80bd-f814dae02ea5" />

### 5th Case Console Output:

<img width="381" alt="Screenshot 2025-07-05 at 5 38 14 PM" src="https://github.com/user-attachments/assets/4916180c-df10-4aac-b31f-f34bfb153b68" />

Input: Customer's cart is empty.
Expected Result:
CartEmptyException thrown.
No shipment/receipt printed.
