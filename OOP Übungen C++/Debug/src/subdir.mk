################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/OOP\ �bungen.cpp 

OBJS += \
./src/OOP\ �bungen.o 

CPP_DEPS += \
./src/OOP\ �bungen.d 


# Each subdirectory must supply rules for building sources it contributes
src/OOP\ �bungen.o: ../src/OOP\ �bungen.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -std=c++0x -O1 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"src/OOP �bungen.d" -MT"src/OOP\ �bungen.d" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


