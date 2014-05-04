################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/OOP\ Übungen.cpp 

OBJS += \
./src/OOP\ Übungen.o 

CPP_DEPS += \
./src/OOP\ Übungen.d 


# Each subdirectory must supply rules for building sources it contributes
src/OOP\ Übungen.o: ../src/OOP\ Übungen.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -std=c++0x -O1 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"src/OOP Übungen.d" -MT"src/OOP\ Übungen.d" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


