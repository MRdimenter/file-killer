public enum Regex {
    JPEG(".*\\.jpeg|.*\\.jpg|"),
    PNG(".*\\.png|"),
    EXCEL(".*\\.xls|.*\\.xlsx|");

    private String expression;

    Regex(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

}
