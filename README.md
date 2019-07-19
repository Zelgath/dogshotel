# dogshotel
Buisness application made to schedule the stay of dogs, check which cages are free, store the data about dogs, count the price for each stay, store the data about clients.
01.07.2019 - first source files
11.07.2019 - Application is working on MySQL Database, informations about cages and dogs (with Owner info) are stored.

To run application we need to create MySql Database named: 'dogshotel', and run sql scripts which are uploaded in folder sqlscripts.

On the main page (localhost:8080/dogs) we can se a table with dogs that are signed. From this point we can check the list of cages, remove dog from list, add a new dog to the list and assign a Cage to the dog:
![obraz](https://user-images.githubusercontent.com/48680815/61532879-931d5700-aa2b-11e9-866a-5f1294763acd.png)

After clicking "dodaj psa" link, we will be directed to dog adding form. Here we can put the informations about dog and the owner. Fields "imie", "rasa" and "wiek" cannot stay empty to add a dog (if we will not type anything we will be redirected to form again with information that fields cannot be empty). We can choose a dog sex from four different types (these information may be useful for the owners of buisness). After filling everything and clicking "dodaj psa" button we are redirected to the table with dogs. We can see a new dog and it is already stored in database.
![obraz](https://user-images.githubusercontent.com/48680815/61054437-baeb3a00-a3ef-11e9-9510-1634d0201a7d.png)

If dog has not assigned cage we can click a link "przypisz kojec". We will be directed to the assign cage form where we can choose from drop-down list which cage we want to assign. Only cages which are not occupied will appear on the list. We have to type also a duration of stay. After a duration of stay program will automaticly disconnect cage from dog and make it free.
![obraz](https://user-images.githubusercontent.com/48680815/61055073-0520eb00-a3f1-11e9-8a9a-e6285fbe6f47.png)

After assigning a cage we will be redirected to the dogs list. If we click "Podglad" link in a each dog row we can check specific informations about dog and it's owner. We can also check the amount of money which owner has to pay for the stay. We can zero the charge of owner to mark that stay is already paid(in a close future I will add functions to get the total amount of monthly earnings).
![obraz](https://user-images.githubusercontent.com/48680815/61055490-e707ba80-a3f1-11e9-95e3-f2e9c93b6e74.png)

Finally after clicking "lista kojców" link on localhost:8080/dogs we will be directed to the site which contains a table with cages and flags if it is free or occupied. Previously I've assigned "Duży kojec 1" and "Pokój w budynku 5" and we can see that in the table these cages are marked as occupied.

![obraz](https://user-images.githubusercontent.com/48680815/61055788-85941b80-a3f2-11e9-98c8-276b655dd259.png)

In close future I will add some functionalities to the program and spring security. 



 
