![ Image May 29, 2025, 12_40_33 AM](https://github.com/user-attachments/assets/ffdb43ce-d68b-4842-97ef-28b48a129f2c)
# 🥪 DELI-cious – Sandwich Shop Ordering App (Java CLI Project)

Hi there! 👋 Welcome to **DELI-cious**, a fun and colorful sandwich shop ordering app I built in Java. If you've ever walked into a deli and thought, “I just want to build my sandwich, pick a drink, and go,” then you're in the right place.

This app lets users build custom sandwiches by picking bread, meats, cheese, toppings, and sauces, just like in a real sandwich shop. They can also add drinks and chips, review their order, add tips if they want, and get a receipt saved to the system  all from a simple and friendly command-line interface.

---

## 🧾 What This App Does

### 👤 For Customers:
You can walk through a virtual ordering experience that feels like a real deli:

- Choose **dine-in or takeout**
- Pick your bread (like white, wheat, rye, or wrap)
- Choose sandwich **size** (4”, 8”, 12”)
- Add meats, cheeses, regular toppings, and sauces
- Ask for **extras** (like extra bacon or cheese)
- Decide if you want your sandwich **toasted**
- Add a **drink** and **chips**
- Confirm your order and receive a **receipt with the total price and timestamp**

At the end, the app prints a clean receipt and saves it to a file so it's like a real POS (Point-of-Sale) system.

---

## 🛠️ How It Was Built

This app was made using Java and built entirely in the terminal (CLI = Command Line Interface). It uses Object Oriented Programming (OOP)  a method that organizes code into reusable building blocks called "classes."

Some of the major concepts used:

- **Encapsulation**: Keeps each feature self-contained (e.g., drinks, chips, bread all have their own logic)
- **Inheritance**: Signature sandwiches are based on the standard sandwich class but have their own fixed ingredients
- **Polymorphism**: The receipt treats everything (sandwich, chips, drinks) as a `MenuProduct`  even though they behave differently behind the scenes
- **Abstraction**: Things like pricing, extras, and categories are all simplified through helpful classes and methods

---

## 📂 Main Features Explained

| Feature                      | What It Does                                                                 |
|-----------------------------|------------------------------------------------------------------------------|
| 🧾 Home Screen              | Start a new order or exit the app                                            |
| 🍞 Bread Menu               | Choose from 4 types of bread (with skip and cancel options)                  |
| 📏 Sandwich Size            | Pick 4”, 8”, or 12” — size affects price                                      |
| 🥓 Toppings by Category     | Meats, Cheeses, Regular Toppings, Sauces — all shown in numbered lists       |
| ➕ Extra Option             | Easily add "extra cheese" or "extra bacon" for extra cost                    |
| 🔥 Toast Option             | Choose whether or not to toast the sandwich                                  |
| 🥤 Drink Menu              | Pick a drink size and flavor using a number (no typing names)                |
| 🍟 Chips Menu              | Pick from fun flavors (e.g., BBQ, Jalapeño, Sour Cream, Lays Classic)        |
| ⭐ Signature Sandwiches     | Choose a preset sandwich like BLT or Philly Cheese                          |
| 💾 Save Receipts          | Receipt is saved automatically in a file with date + time in the filename + Tip |
| 🎨 Color & Emoji Friendly   | Everything is formatted with fun emojis and ANSI colors to make it engaging  |

---
![diagdelicious_uml_diagram](https://github.com/user-attachments/assets/01af8f51-f895-40ed-ba15-31f8caf9bbd1)


----
<img width="1321" alt="Screenshot 2025-05-30 at 9 35 44 AM" src="https://github.com/user-attachments/assets/47d25269-dbee-4bec-9adf-24a7edfbe6b5" />
<img width="1330" alt="Screenshot 2025-05-30 at 9 36 55 AM" src="https://github.com/user-attachments/assets/e7a05bfd-1370-4c56-8b21-04c963b6731c" />
<img width="1354" alt="Screenshot 2025-05-30 at 9 37 27 AM" src="https://github.com/user-attachments/assets/9156b0e7-06db-4e9e-9541-3e643ba23841" />
<img width="1329" alt="Screenshot 2025-05-30 at 9 38 05 AM" src="https://github.com/user-attachments/assets/cfb1598a-2f09-4a02-ad1d-944acbb06dbe" />
<img width="1284" alt="Screenshot 2025-05-30 at 9 38 25 AM" src="https://github.com/user-attachments/assets/352466fa-13f3-43be-b722-e7cc1e02c7b0" />
<img width="652" alt="Screenshot 2025-05-30 at 9 38 49 AM" src="https://github.com/user-attachments/assets/61c20dda-2146-4bbf-867b-2a6cdca1b08c" />

____

Interesting Code 
*Instead of writing separate logic for each topping type (meats, cheese, sauces), I used a Map<String, List<String>> and looped through each category. This makes my code scalable and cleaner:

<img width="633" alt="Screenshot 2025-05-30 at 9 44 42 AM" src="https://github.com/user-attachments/assets/b57f9d6d-c473-44c3-bc12-cc410d84f252" />



____

## 📸 Sample Output (Looks Like This)

Order Type: Takeout
Time: 2025-05-30 14:12:05

- 12" Wheat Sandwich (toasted)
  - Ham [$1.50]
  - Swiss (extra) [$2.00]
  - Pickles [$0.00]
  - Mustard [$0.00]

- Large Lemonade [$2.50]
- Chips - Jalapeño [$1.50]

Subtotal: $11.50  
Tax (10%): $1.15  
Tip: $2.00  
Total: $14.65  
Estimated Wait Time: 10–15 minutes
