# Datapack – Overworld / Nether Coordinate Conversion
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

## Installation

1. Download or clone this repository
2. Copy the `portalculator` folder into: `.minecraft/saves/<your_world>/datapacks/`
3. Launch the world
4. Run the following command if the datapack is not loaded: `/reload`

## Datapack Structure

```
data/
├── minecraft/
│   └── tags/
│       └── functions/
│           └── load.json
└── coordinate/
    └── functions/
        ├── load.mcfunction
        ├── nether.mcfunction
        └── overworld.mcfunction
```

### Technical Details

* Objectives: `px`, `py`, `pz`

* Constants: `#factor8`, `#halffactor`

## In-game Usage

### Nether Coordinates (Overworld ÷ 8)

```mcfunction
/function coordinate:nether
```

Displays the equivalent Nether coordinates for the player.

### Overworld Coordinates (Nether × 8)

```mcfunction
/function coordinate:overworld
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
