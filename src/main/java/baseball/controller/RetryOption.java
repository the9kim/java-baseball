package baseball.controller;

public enum RetryOption {

    RETRY("1", true),
    END("2", false);

    private String retryInput;
    private boolean retryDecision;

    private static final String RETRY_DECISION = "1";
    private static final String END_DECISION = "2";

    RetryOption(String retryInput, boolean retryDecision) {
        this.retryInput = retryInput;
        this.retryDecision = retryDecision;
    }

    public static RetryOption of(String retryInput) {
        for (RetryOption decision : RetryOption.values()) {
            if (decision.retryInput.equals(retryInput)) {
                return decision;
            }
        }
        throw new IllegalArgumentException("[ERROR] 1 또는 2가 아닙니다");
    }

    public boolean isRetryDecision() {
        return retryDecision;
    }
}
