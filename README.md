lol-api-library
===============

LoL Api Library is a simple wrapper for Riot Games' web services.

#### Currently supported services:
- Retrieve list of champions 
- Get player's recent games
- Get player's leagues
- Get player's statistics
- Get player's ranked statistics
- Get player's mastery pages
- Get player's rune pages
- Get summoner by name
- Get summoner by id
- Get players' names
- Get player's teams



#### Setup

There are only a few things you need to do in order to start using LoL Api Library.

- Add lol-api-library as a library project to your Android application
- Add INTERNET permission to your application by adding the followin line to your Android Manifest file:

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

- Add you API Key as a META-DATA named  "yanovski.lol.api.API_KEY" to your Android Manifest file:

```xml
<meta-data
            android:name="yanovski.lol.api.API_KEY"
            android:value="INSERT_YOUR_API_KEY_HERE" />
```

- Call LoLServices.init(Context) method at least once before starting to use the LoLServices' other methods. You could just add the following call to your Activity or Application's onCreate method.

```java
LoLServices.init(this);
```

#### Workflow

All services are exposed as methods to the LoLServices class. They are all asynchronious. Every method returns a unique string - the UUID of the current request.

All responses are delivered as messages using Otto's message bus. Any class interested in these messages should subscribe for them by:

- Implement a ```public void``` method with a single parameter - the parameter being the message you want to listen for. Here is an example method listening for ```SummonerResponseNotification```.

```java
@Subscribe 
public void processResponseNotification(SummonerResponseNotification rn) {
...
}
```

As you can see, these methods have to be marked with the ```@Subscribe``` attribute.

- Once you've implemented all such methods, you have to register your class' instances to the message bus. You can do this by calling:

```java
EventBusManager.register(this);
```

You could unregister at any moment by calling:

```java
EventBusManager.unregister(this);
```


##### Response types

All response types are in the ```yanovski.lol.api.responses``` package.
When you implement your listening methods you could either specify one of these classes - for example ```SummonerResponseNotification``` if you are interested in any updates carrying ```Summoner``` data or specify ```ResponseNotification<?>``` meaning you are interested in any data received from the Riot's services.

Every message is carrying it's request id, so you could check if this is the one you've invoked.


#### TODO List

- Implement data caching
- Extend the ```ResponseNotification``` to include the request parameters used for the current request

#### Credits and attributions

- Riot Games - for providing their API
- Retrofit (http://square.github.io/retrofit/) - used for the HTTP requests
- Otto (http://square.github.io/otto/) - used for the message delivery


#### License

This product is provided under the The MIT License (MIT). For more information please refer to the LICENSE file.




######This product is not endorsed, certified or otherwise approved in any way by Riot Games, Inc. or any of its affiliates.
