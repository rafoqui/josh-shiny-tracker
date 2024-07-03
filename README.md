# Josh SH Helper

Web App for pokemon shiny hunters.

![Project Screenshot](https://github.com/rafoqui/josh-shiny-tracker/blob/master/demo.gif?raw=true)

## Features
* Keeps track on multiple hunts and lets you add new ones.
* Displays odds in real time for each hunt.
* Lets you manipulate the counter for each hunt.
* Shows a matching sprite for the generation selected.
* Stores the finished hunts in the 'Past Hunts' tab (click on the luxury ball).
* Supports the following methods
  - Random encounters/Soft resets (Full Odds)
  - Shiny breeding (Crystal version only)
  - Masuda
  - Radar chain (DPP, XY, ORAS, BDSP)
  - Friend Safari
  - Chain fishing
  - Hordes
  - DexNav (It shows full odds at the moment)
  - S.O.S. battles
  - KOs Bonus (SWSH Pokedex bonus)
  - Dynamax adventures

## Known issues
* Currently does not include generation 9.
* DexNav shows full odds. This is because, to calculate the most accurate odds at which the game forces the pokemon to be shiny, the tracker would have to include the 'Search Level' for the selected pokemon, and such feature is not currently supported in the tracker. [For a more complete analysis of the mechanic.](https://bulbapedia.bulbagarden.net/wiki/DexNav#Hidden_Pok%C3%A9mon)
* Currently does not show the models for BDSP when selecting gen 8.

## Credits

  - [Pokemondb](https://pokemondb.net/sprites) for all the 2D sprites.
  - [pkparaiso](https://www.pkparaiso.com/espada_escudo/sprites_pokemon.php) for all the 3D sprites source and theSLAYER for sharing them in [projectpokemon](https://projectpokemon.org/home/docs/spriteindex_148/3d-models-generation-1-pok%C3%A9mon-r90/), where I took them from.
  - [Source code](https://codepen.io/samnorton/pen/oNYajYM) for form template inspiration.
  - [Source code](https://codepen.io/mikemang/pen/GRrBRZM) for the target's container inspiration.
  - [Bulbapedia](https://bulbapedia.bulbagarden.net/wiki/Shiny_Pok%C3%A9mon) for most of the odds calculations.
  - Project's name is a tribute to SHJosh. 

