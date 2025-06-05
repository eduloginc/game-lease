# Game Lease

You are working in a company that developed a very simple games lease application.
There is an already existing feature, which is to display, in text format, the output of a lease statement:

```
Games leased by Martin
  The Brain 3.5
  Virus of the mind 2.0
Amount is 5.5
You earned 2 loyalty points
```

The developer who originally built this feature is no longer with the company. Your manager has now asked for a new feature to be implemented:
In addition to the existing functionality, the application should now also be able to display the lease statement in HTML format.

```
<h1>Games leased by <em>Martin</em></h1>
<table>
  <tr><td>The Brain</td><td>3.5</td></tr>
  <tr><td>Virus of the mind</td><td>2.0</td></tr>
</table>
<p>Amount is <em>5.5</em></p>
<p>You earned <em>2</em> loyalty points</p>
```

You will first have to understand what the business rules are, and then implement this new feature, showing us your design/refactoring skills.

## Build

All you need to build this project is Java 11 or later, Maven 3.0 or later.

## Testing

Unit tests can be run using maven[1]:

    $ mvn test

Tests are located in the test directory and run using Junit.
