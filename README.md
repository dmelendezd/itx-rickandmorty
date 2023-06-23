# itx-rickandmorty

This repository contains an Android app which allows the user to access Rick and Morty's characters and locations information, as well as related episodes data, through the API provided at https://rickandmortyapi.com/

# Architecture
According to the nature, size and scope of the app, it has been implemented following an MVP architecture and structured in three main packages whose purpose is to clearly delimit view, model and persistence layers.

Each class on the project has beein developed keeping in mind the SOLID principles in order to obtain a clean result easy to understand and easy to maintain over time.

The app follows the single activity principle and some classes implement the Singleton pattern in order to keep its concept and responsability clear.
