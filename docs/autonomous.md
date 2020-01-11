# Autonomous Software Documentation

## Requirements

Insert a high level description of what this system is attempting to do, but be detailed about it. Think of it like your module’s software “playbook” (like in football). For example, an autonomous description could be:

> During the 15 second autonomous period, we plan to move past the auto starting line, move through our alliance trench, and score the three on-board balls into the hole. We plan to account for three different starting robot configurations (left, center, and right).

## Procedure

Describe with more detail exactly how the high level requirement will be executed. Include implementation details, like which algorithms you will be using, what sensors you will be accessing. For example, a description of an autonomous winch operation could be:

> The winch will be directly controlled by the teleoperated driver using the Joystick #3. We will map the vertical position of the joystick to the winch’s rotation velocity. To ensure the winch is stable, but we do not stall the motor, we will monitor the current that the motor draws dynamically. If the current drawn surpasses a specific threshold, the power to the motor will be reduced/cut off.

## Timeline/Details

Again this a sample, but this is what it would like for the same example as the last:

- [x] **1/7/2020** - Create the software documentation markdown page.
- [ ] **1/9/2020** - Acquire data from the motor controller that specifies how much current a specific motor is drawing
- [ ] **1/15/2020** - Implement and test velocity control PID