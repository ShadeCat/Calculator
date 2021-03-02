abstract class Operation{
    abstract public double execute(double first_number, double second_number);
}

class Adder extends Operation{

    @Override
    public double execute(double first_number, double second_number) {
        return first_number + second_number;
    }
}

class Subtractor extends Operation{

    @Override
    public double execute(double first_number, double second_number) {
        return first_number - second_number;
    }
}

class Multiplier extends Operation{

    @Override
    public double execute(double first_number, double second_number) {
        return first_number * second_number;
    }
}

class Divisor extends Operation{

    @Override
    public double execute(double first_number, double second_number) {
        return first_number / second_number;
    }
}