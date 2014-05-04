################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/uebung01/aufgabe02/quicksort.cpp 

OBJS += \
./src/uebung01/aufgabe02/quicksort.o 

CPP_DEPS += \
./src/uebung01/aufgabe02/quicksort.d 


# Each subdirectory must supply rules for building sources it contributes
src/uebung01/aufgabe02/%.o: ../src/uebung01/aufgabe02/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -std=c++0x -I"C:\Users\Max\workspace_cpp\OOP Übungen C++\src" -O1 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


