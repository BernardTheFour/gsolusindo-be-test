# Project

This project demonstrates how to run Docker Compose on WSL (Windows Subsystem for Linux). Follow the steps below to get started.

## Prerequisites

- Windows 10 or later
- WSL 2 installed
- A WSL 2 Linux distribution installed (e.g., Ubuntu)
- Docker Engine installed and running on WSL

## Usage

### Running Docker Compose

1. Navigate to root project directory containing the `docker-compose.yml` file:

    ```bash
    cd /path/to/your/project
    ```

2. Start the services defined in your `docker-compose.yml` file:

    ```bash
    docker compose up
    ```

3. To run Docker Compose in detached mode (in the background):

    ```bash
    docker compose up -d
    ```

4. To stop the running services:

    ```bash
    docker compose down
    ```

### Running The Program

1. Navigate to root project directory containing the `docker-compose.yml` file:

    ```bash
    cd /path/to/your/project
    ```

2. Run bash script defined in the `run.sh` file:

    ```bash
    sh run.sh
    ```
