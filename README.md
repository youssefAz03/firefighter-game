# Firefighters Project - README

## Project Description
Firefighters is a Java-based simulation project where you navigate a grid-based world with various terrain types and entities. In this project, you control firefighters (both standard and motorized), aiming to extinguish fires that spontaneously appear in random locations. The grid world has different types of tiles, each with specific rules and behaviors:

- **Fire (Red)**: Represents the fire, which needs to be extinguished.
- **Firefighters (Blue)**: Represents the firefighters tasked with extinguishing fires.
- **Motorized Firefighters**: A special type of firefighter that can move two steps at a time.
- **Mountains**: Inaccessible terrain where neither fire nor firefighters can enter.
- **Roads**: Terrain where only firefighters can move.
- **Clouds**: These can extinguish fires on contact and appear in random locations.

## Project Structure
The project contains several Java classes to manage the simulation's components, including:

- **Grid.java**: Defines the grid-based environment, allowing for setup, initialization, and operations on the grid.
- **Fire.java**: Represents a fire entity with properties such as position and behavior when extinguished.
- **Firefighter.java**: Represents a standard firefighter entity with movement and extinguishing capabilities.
- **MotorizedFirefighter.java**: A specialized firefighter with the ability to move two steps at a time.
- **Mountain.java**: Represents a mountain tile, an impassable terrain type.
- **Road.java**: Represents a road tile where firefighters can move more freely.
- **Cloud.java**: Represents a cloud entity that moves and randomly extinguishes fires.

## Setup Instructions
1. Clone the repository to your local environment.
2. Ensure you have Java Development Kit (JDK) installed on your system.
3. Navigate to the project directory in your terminal or command prompt.
4. Compile the Java source files with the following command:
   javac -d out src/*.java
5. Run the simulation using the following command:
   java -cp out Main

## How to Play
- The simulation begins with a randomly generated grid containing fires, firefighters, mountains, roads, and clouds.
- Use mouse  to control the firefighters' movements:
- The goal is to extinguish all fires as quickly as possible.
- Avoid mountains, as they are impassable.
- Use roads to move firefighters more efficiently.
- Clouds move randomly and can extinguish fires upon contact.

## Known Issues
- Sometimes the simulation may have performance issues with larger grid sizes.
- Rarely, clouds may not extinguish fires even when overlapping.

## Future Improvements
- Add more terrain types for greater variety.
- Implement different firefighting tools and equipment.
- Allow for multiplayer or cooperative gameplay.
- Introduce weather conditions that affect the spread and extinguishing of fires.

## License
This project is licensed under the [Your License Name]. Please read the LICENSE file for more information.
