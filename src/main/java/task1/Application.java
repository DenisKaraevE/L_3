package task1;

public interface Strategy {

    @NotNull
    String process(@NotNull List<String> stings);

}
public interface StrategyService {

    String exec(List<String> strings);

    StrategyService setStrategy(@NotNull Strategy strategy);

}
public class CommaSeparatedStrategy implements Strategy {

    @NotNull
    @Override
    public String process(
            @NotNull List<String> stings
    ) {
        return StringUtils.join(stings, ",");
    }

}
public class SemicolonSeparatedStrategy implements Strategy {

    @NotNull
    @Override
    public String process(
            @NotNull List<String> stings
    ) {
        return StringUtils.join(stings, ";");
    }

}
public class StrategyServiceImpl implements StrategyService {

    private Strategy strategy;

    public StrategyServiceImpl(
            @NotNull Strategy strategy
    ) {
        this.strategy = strategy;
    }

    @Override
    @NotNull
    public String exec(@NotNull List<String> strings) {
        String result = "";
        if(strings.isEmpty())
            return result;

        return strategy.process(strings);
    }

    public StrategyService setStrategy(
    @NotNull Strategy strategy
 ) {
        this.strategy = strategy;
        return this;
    }
}
