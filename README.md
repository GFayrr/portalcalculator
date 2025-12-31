# Datapack – Overworld / Nether Coordinate Conversion

## Description

This Minecraft datapack allows players to display the equivalent coordinates between the Overworld and the Nether, following the official Minecraft conversion rule:

* Overworld → Nether: divide by 8
* Nether → Overworld: multiply by 8

All calculations are handled using scoreboards, ensuring reliability and full compatibility with vanilla Minecraft mechanics.

## Features

* Displays converted player coordinates
* Two separate functions:

* `nether.mcfunction` → Overworld coordinates ÷ 8
* `overworld.mcfunction` → Nether coordinates × 8
* Preserved precision using a scaling factor
* Works in singleplayer and multiplayer
* No mods required

## Datapack Structure

```
data/
├── minecraft/
│   └── tags/
│       └── functions/
│           └── load.json
└── coords/
    └── functions/
        ├── load.mcfunction
        ├── nether.mcfunction
        └── overworld.mcfunction
```

---

## Initialization (`load.mcfunction`)

The `load.mcfunction` file is executed automatically:

* when the datapack is loaded
* when the world starts
* when using the `/reload` command

Its purpose is to:

* create the required scoreboard objectives
* initialize mathematical constants

### Expected setup

* Objectives:
* `px`, `py`, `pz`

* Constants:
* `#rat8`

## In-game Usage

### Nether Coordinates (Overworld ÷ 8)

```mcfunction
/function coords:nether
```

Displays the equivalent Nether coordinates for the player.

### Overworld Coordinates (Nether × 8)

```mcfunction
/function coords:overworld
```

Displays the equivalent Overworld coordinates for the player.

## Precision and Limitations

* Values are rounded
* Y-coordinate is not converted

## Compatibility

* Minecraft versions: 1.21.1x
* Works in survival mode if commands are enabled
* Multiplayer compatible

## License

You are free to use, modify, and redistribute this datapack.
