# DAT250 Experiment Assignment 7

## Technical Problems Encountered

During the completion of the RabbitMQ tutorials (Experiments 1-4), several technical challenges were encountered:

### 1. Gradle Configuration
- Initially, there were issues with running the Java classes using Gradle due to misconfigurations in the `build.gradle` file. Specifically, the main class was not correctly specified, and external dependencies like RabbitMQ's `amqp-client` were not resolved.
- This was fixed by adding the correct `mainClass` property and defining the necessary dependencies in the `build.gradle` file, alongside ensuring repositories were correctly declared.

### 2. Classpath Issues
- There was a recurring issue with `NoClassDefFoundError`, specifically related to missing RabbitMQ client libraries and SLF4J. This was resolved by ensuring the classpath included the correct paths for the required external JAR files.

### 3. Running Multiple Consumers
- When trying to run multiple consumers in parallel (for the Work Queue and Publish/Subscribe experiments), the initial setup of RabbitMQ consumers and producers across different terminals was slightly challenging due to RabbitMQ's behavior in message dispatching (round-robin vs broadcast).

## Links to Code

You can find the source code for all four experiments in the following repository:

[**Link to repository**](https://github.com/your-repo/dat250-experiments)

Make sure to check the respective directories for each experiment:
- **Experiment 1**: Hello World
- **Experiment 2**: Work Queues
- **Experiment 3**: Publish/Subscribe
- **Experiment 4**: Topics

## Screenshots

### Experiment 1: Hello World
![experiment1_screenshot](https://github.com/user-attachments/assets/cbb015f2-178f-463c-b2cd-792b8c757734)

### Experiment 2: Work Queues
![experiment2_screenshot](https://github.com/user-attachments/assets/3dc98435-5a39-46ad-9552-742e8ace43da)

### Experiment 3: Publish/Subscribe
![experiment3_screenshot](https://github.com/user-attachments/assets/df072109-e9e3-4a89-be38-0bd123723f44)

### Experiment 4: Topics
![experiment4_screenshot1](https://github.com/user-attachments/assets/326e0606-af1b-4d51-a1af-6a3f02a5596e)
![experiment4_screenshot2](https://github.com/user-attachments/assets/34bcd11a-ebc6-4389-81d7-527e1fbd8c6f)

## Pending Issues

### 1. Deprecation Warnings
- While running the code with Gradle, there were deprecation warnings related to future Gradle releases (particularly Gradle 9). These warnings do not affect functionality in this version but will need addressing in the future.

### 2. Manual Classpath Configuration
- Although Gradle was used for building and running the code, some manual configuration of the classpath was necessary to resolve dependency issues for certain tests. This could be streamlined by improving the Gradle build configuration further.

Other than these minor issues, all experiments were successfully completed.
