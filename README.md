# EShopping_GUI_App
A **_Java GUI App_** for EShopping/Online Shopping , developed using concepts of **JavaFX, Java SQL &amp; MySql**.
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
The Add Products button _on-click_ will display a *form* and **Add Product Button* on the _work area_.\
The form will have some text-field in which data for the appropriate field of **product item** is to be filled by _admin_.\
If the data filled is according to the required format then on clicking the "Add Product" button the product item will be added to the\
**_product database / Inventory_**.
<p align="center">
<img src="https://github.com/VamshiRk27/EShopping_GUI_App/blob/main/EShopping-App/EShopping%20ScreenShots/UI%20to%20add%20Products%20to%20the%20Database%20or%20inventory%20by%20Admin.png" width="400" height="400" />
</p>
<p align="center">Add Products</p>
