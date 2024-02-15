package model;

public class Gate extends BaseModel{
    private Gatetype gatetype;
    private int gateNumber;
    private Operator currentOperator;
    private GateStatus gateStatus;

    public Gatetype getGatetype() {
        return gatetype;
    }

    public void setGatetype(Gatetype gatetype) {
        this.gatetype = gatetype;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Operator getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(Operator currentOperator) {
        this.currentOperator = currentOperator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
