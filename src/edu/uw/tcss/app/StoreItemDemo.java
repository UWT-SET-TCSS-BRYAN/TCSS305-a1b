import static java.lang.IO.*;
import edu.uw.tcss.model.StoreItem;

void main() {
    final StoreItem si = new StoreItem("Laptop", BigDecimal.valueOf(999.99));
    println(si);
    println(si.getName());
    println(si.getPrice());
    println(si.calculateTotal(2, false));
    println(si.calculateTotal(2, true));
    println(si.getFormattedDescription());
}

