# EShopping_GUI_App
A **_Java GUI App_** for EShopping/Online Shopping , developed using concepts of JavaFX, Java SQL &amp; MySql.\

Tech Stack used: **JavaFX**, **Java SQL**.\
Tools used: **IntelliJ IDE** , **MySQL Workbench**.
## Introduction
This app has been developed on the idea of shopping products online.\
Many Functionalities/Features like **Login, SignUp, Search, Cart, Products List & Log-out** have been achieved in the _Development stage_ of this App.

The Basic Flow of the app can be seen in the below shown image.

<p align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/App%20Flow.png?raw=true" width="700" height="450" />
</p>
<p align="center">App Flow</p>

## App Flow
The Initial run of the app displays us the **_Welcome Page_** of app with the login option for 2 types of users i.e, **Admin & Customer**.\
On clicking on appropriate login option the app displays login for that particular user type login page. 
<p align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/MainPage.png" width="400" height="400" />
</p>
<p align="center">Welcome Page</p>

<div align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/Admin%20Login%20Page.png" width="350" height="350">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/Customer%20Login%20Page.png" width="350" height="350">
</div>
<p align="center">
Login-Page for Admin and Customer.
</p>

### Admin
On Successful login for admin the app will display **_Admin HomePage_** with buttons **Search, Customers, Products, Add Products & Log-Out** where each button on click will visually display the appropriate feature on _Admin HomePage_.\
Each button has a different functionality which has a different task to perform.
A section which is in red color on _home page_ is used as a base for different frames to be displayed and let's name this section as *Work area*. 
<p align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/Admin%20HomePage.png" width="400" height="400" />
</p>
<p align="center">Admin HomePage</p>

#### Customers
The Customers button _on-click_ performs a task in which all the **_existing customers_** with their respective data from the database are retrieved and displayed on the _work area_.
<p align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/UI%20for%20Admin%20to%20view%20all%20the%20existing%20Customers.png" width="400" height="400" />
</p>
<p align="center">Customers List</p>

#### Add Products
The Add Products button _on-click_ will display a *form* and **Add Product** Button on the _work area_.\
The form will have some text-field in which data for the appropriate field of **product item** is to be filled by _admin_.\
If the data filled is according to the required format then on clicking the "Add Product" button the product item will be added to the\
**_product database / Inventory_**.
<p align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/UI%20to%20add%20Products%20to%20the%20Database%20or%20inventory%20by%20Admin.png" width="400" height="400" />
</p>
<p align="center">Add Products</p>

#### Products
The Product button has the functionality to display all the **products** which are available/exisiting in the **_inventory_**.
<p align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/UI%20for%20Admin%20to%20check%20or%20view%20the%20Inventory.png" width="400" height="400" />
</p>
<p align="center">UI for Admin to check or view the Inventory</p>

### Customer
On _Customer Login_ page the user has to login using their login credentials.\
If the customer is an _existing user_ then the user is redirected to **"Customer HomePage"** else, if login is **failed** then the user will be redirected to **_Sign-Up Page_** and is required to **Sign-Up** as a new user by providing mentioned details related to user.\
On successful user registration an alert dialog will be popped up confirming the status of registration.
<div align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/Customer%20Login%20Page.png" width="350" height="350">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/SignUp%20Page%20for%20new%20Customer%20registration.png" width="350" height="350">
</div>
<p align="center">
Login-Page & Sign-Up page for Customer.
</p>

On successful login the customer is redirected to Customer HomePage where all the products are displayed in the form of list with each column having some appropriate information related to the product.\
The Interface developed here for **Customer HomePage** is similar to the **Products** page of Admin.
<div align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/Customer%20HomePage%20with%20Products.png" width="400" height="400">
</div>
<p align="center">
Customer HomePage.
</p>

#### Search
Search button takes some text input as **keyword** and filters all the products which has keyword in the product name.\
When there exist no products in the **inventory** with the keyword as product name an **empty list** is displayed on the screen.\
The search button functionality becomes handy when the user looks for a particular product from large set of product data.
<p align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/Search%20bar%20for%20searching%20required%20Products.png" width="400" height="400">
</p>
<p align="center">
Search bar with some input text as keyword.
</p>


<div align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/Search%20results%20if%20product%20exist%20.png" width="350" height="350">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/Search%20results%20for%20non%20existing%20Product.png" width="350" height="350">
</div>
<p align="center">
Search results for existing and non-existing products respectively.
</p>

#### Add to Cart & Buy Now
Add to cart and Buy now buttons are deployed to implement the functionality to add a product into **customer cart** and **buy** a product respectively.\
A product is **selected** from the **product list** and when any of the each button are clicked will implement its appropriate function.\
A pop-up alert is appeared for confirmation for product addition and if the product is added to the cart a successful addition alert pop-up will be popped-up on the screen.
<p align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/Pop-Up%20to%20confirm%20product%20addition%20to%20cart.png" width="400" height="400">
</p>
<p align="center">
Confirmation pop-up for product addition to Customer cart.
</p>

#### Cart
The Cart functionality is deployed to show the list of items which the user / customer has added into their cart.\
The _Cart_ button on the customer homepage on click will display the cart items on the screen and a _Back_ button is deployed in cart page which\
on-click will redirect the customer back to **home page**.
<p align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/User%20Cart%20after%20adding%20some%20products%20into%20cart.png" width="400" height="400">
</p>
<p align="center">
Customer Cart.
</p>

### Log Out
A **Log-out** button is added for _admin_ & _customer_ which has same functionality for both type of users.\
The log out button on-click will pop-up a confirmation dialog requestiong the admin / customer to confirm the action to be performed.\
On clicking **_Ok_** the user i.e, admin/customer is successfully **logged out** and will be redirected to Welcome page.
<p align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/pop-up%20for%20logging%20out%20for%20Admin.png" width="700" height="700">
</p>
<p align="center">
Confirmation pop-up for the action to be performed on Log-out.
</p>

## Conclusion
Author: **VamshiRK**.
