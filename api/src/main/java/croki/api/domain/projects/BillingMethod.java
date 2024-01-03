package croki.api.domain.projects;

public enum BillingMethod {
    BASED_ON_PROJECT_HOURS("Based on project hours"),
    FIXED_COST_FOR_PROJECT("Fixed cost for project");

    private final String displayName;

    BillingMethod(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
