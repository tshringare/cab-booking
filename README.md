<h1>Cab Booking</h1>
<h2>Introduction</h2>
<p> This repository is a framework which can be used to implement a cab booking system. These classes and their methods provide a very basic implementation of a cab booking service such as registration of a user as either a driver or a passenger, allowing passengers to select what type of car they want, calculating displaying the fare, and allowing the driver to find suitable and the closests ride requests. This repository could thus be used to develop and implement a bare bones cab-booking application, while providing room for improvement and customization. The Main class can be run to see an outline of how each class interacts with one another.</p><br>
<h2>Working</h2>
This section provides basic details of how each of the classes work.<br><br>
<ol>
  <li><b>Coordinate: -</b>
  <p>A simple implementation of a two dimensional coordinate system used to define a point which contains methods to set x and y coordinates of a point, along with a method to get the distance between two points. Used to find the closest passenger for a specific driver and to calculate the cab fare.</p></li>
  <li><b>Booking: -</b>
  <p>The Booking class is defined to include all the important details of a booking and to track all the bookings. For this, the class contains three static arraylists which track all the passenger requests, all the active bookings and all the completed bookings seperately. A specific booking may have will have a driver, a passenger, the car type, some source and destination, and a fare which is calculated using a method. Initially when a passenger requests a ride, the booking is stored in the requests arraylist with an unassigned driver. After a driver accepts a the booking is stored in the active bookings list. Finally, once the ride is finished (using a method), the booking is moved to the completed bookings section, which contains all bookings completed.</p></li>
<li><b>Users: -</b>
  <p>This framework contains two types of users, the passengers and the drivers. Thus, an abstract class named users is first defined which contains static arraylists of all passengers and all the drivers seperately, and also contains the basic details that all users would require, such as a username, their password, their current location, along with the methods required to get all of this information 
(NOTE: It is highly recommended that one changes the password attribute and method to store the hash of the password instead of the actual password or using other means of verification to ensure security)
Then we have the passenger and the cab driver classes, which implement this user class and contain specific methods required by the type of user.</p>
    <p>The <b>Passenger</b> class contains a create booking method which in turn requests all the required details, such as the destination and the car type, and returns the fare of the booking.</p>
    <p>The <b>CabDriver</b> class contains methods to enter their vehicle details, get any open ride requests, which returns the closest matching ride request and its details, and assigns it to the driver, and finally a finish ride method, which finishes the ride for the driver and returns the fare, if the driver had any active rides.
  </p></li>
  <li><b>Vehicles: -</b>
  <p>This is a simple vehicle class used primarily by the Bookings and the CabDriver classes to store the name and importantly the type of the vehicle being driven, which is used to calculate fare costs.</p></li>
</ol>
<h2>Usage</h2>
<p>While the classes can be implemented as is to make a very simple cab booking program, it is these are very crude and require many changes to be implemented in an end user cab-booking program, such as the implementation of a proper coordinate system, the creation of a proper user system with secure password storage methods etc. </p>
<p>Thus, this project serves as a very simple and crude foundation of a cab booking app, which provides very basic functionality.</p>
