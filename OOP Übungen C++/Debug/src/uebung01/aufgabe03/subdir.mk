################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/uebung01/aufgabe03/newton.cpp 

OBJS += \
./src/uebung01/aufgabe03/newton.o 

CPP_DEPS += \
./src/uebung01/aufgabe03/newton.d 


# Each subdirectory must supply rules for building sources it contributes
src/uebung01/aufgabe03/%.o: ../src/uebung01/aufgabe03/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -std=c++0x -I"C:\Users\Max\git\oop\OOP �bungen C++\src" -O1 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


