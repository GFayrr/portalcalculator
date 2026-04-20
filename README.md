# Portal Calculator 1.21

A Fabric mod for Minecraft 1.21 that adds a `/convert` command to calculate
Nether portal coordinates.

## Features

- `/convert` — Automatically converts your current position based on your dimension
- `/convert nether <x> <y> <z>` — Converts Overworld coordinates to Nether coordinates
- `/convert overworld <x> <y> <z>` — Converts Nether coordinates to Overworld coordinates

The command is available to all players (permission level 0).

## Usage

### Automatic conversion
Stand anywhere in the Overworld or Nether and type `/convert`.
The mod will detect your current dimension and display the corresponding coordinates.

### Manual conversion
Provide coordinates manually regardless of your current position:

| Command | Result |
|---|---|
| `/convert nether 800 64 -400` | `[Portal Calculator] Overworld (800, 64, -400) → Nether (100, 64, -50)` |
| `/convert overworld 100 64 -50` | `[Portal Calculator] Nether (100, 64, -50) → Overworld (800, 64, -400)` |

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/installer/) for Minecraft 1.21
2. Download [Fabric API](https://modrinth.com/mod/fabric-api)
3. Download the latest `portal-calculator-1.21-x.x.x.jar` from [Releases](../../releases)
4. Place both `.jar` files in your `mods/` folder

## Requirements

| Dependency | Version |
|---|---|
| Minecraft | 1.21 |
| Fabric Loader | ≥ 0.19.2 |
| Fabric API | 0.102.0+1.21 |
| Java | ≥ 21 |

## Building from source

```bash
git clone -b 1.21 https://github.com/GFayrr/portalcalculator.git
cd portalcalculator
./gradlew build
```

The compiled `.jar` will be in `build/libs/`.

## License

This project is licensed under [CC0-1.0](LICENSE) — public domain.
