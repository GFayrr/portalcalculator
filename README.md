# Datapack – Overworld / Nether Coordinate Conversion
This Minecraft datapack allows players to display the equivalent coordinates between the Overworld and the Nether, following the official Minecraft conversion rule:

* Overworld → Nether: divide by 8
* Nether → Overworld: multiply by 8

All calculations are handled using scoreboards, ensuring reliability and full compatibility with vanilla Minecraft mechanics.

## Features

* Displays converted player coordinates
* `convert.mcfunction` → Overworld coordinates ÷ 8 and Nether coordinates * 8
* Preserved precision using a scaling factor
* Works in singleplayer and multiplayer
* No mods required

## Installation

1. Download or clone this repository
2. Copy the `portalculator-<version>` folder into: `.minecraft/saves/<your_world>/datapacks/`
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
        └── convert.mcfunction
```

### Technical Details

* Objectives: `px`, `py`, `pz`

* Constants: `#factor8`, `#halffactor`

## In-game Usage

### Dimension Coordinates convert to the other

```mcfunction
/function coordinate:convert
```

Displays the equivalent coordinates in the other dimension for the player.

## Precision and Limitations

* Values are rounded
* Y-coordinate is not converted

## Compatibility

* Minecraft versions: 1.21.1x
* Works if commands are enabled
* Multiplayer compatible

## License

You are free to use, modify, and redistribute this datapack.
