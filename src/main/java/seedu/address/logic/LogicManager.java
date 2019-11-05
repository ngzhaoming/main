package seedu.address.logic;

import java.util.logging.Logger;

import seedu.address.achievements.logic.AchievementsLogic;
import seedu.address.achievements.logic.AchievementsLogicManager;
import seedu.address.address.logic.AddressBookLogic;
import seedu.address.address.logic.AddressBookLogicManager;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.diaryfeature.logic.DiaryBookLogic;
import seedu.address.financialtracker.logic.FinancialTrackerLogic;
import seedu.address.model.Model;
import seedu.address.model.UserPrefsModel;
import seedu.address.storage.Storage;

/**
 * The main AddressBookLogicManager of the app.
 */
public class LogicManager implements Logic {
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private AddressBookLogic addressBookLogic;
    private AchievementsLogic achievementsLogic;
    private UserPrefsModel userPrefsModel;
    private DiaryBookLogic diaryLogic;
    private FinancialTrackerLogic financialTrackerLogic;
    private Storage storage;

    public LogicManager(Model model, Storage storage) {
        // overloaded AddressBook Logic Manager to pass main model in
        // main model is used to save gui settings
        this.userPrefsModel = model.getUserPrefsModel();
        this.addressBookLogic = new AddressBookLogicManager(userPrefsModel, model.getAddressBookModel(), storage);
        this.achievementsLogic = new AchievementsLogicManager(userPrefsModel, model.statisticsModelSupplier());
        this.diaryLogic = new DiaryBookLogic();
        this.financialTrackerLogic = new FinancialTrackerLogic();
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public AddressBookLogic getAddressBookLogic() {
        return addressBookLogic;
    }

    public AchievementsLogic getAchievementsLogic() {
        return achievementsLogic;
    }

    public DiaryBookLogic getDiaryLogic() {
        return this.diaryLogic;
    }

    public FinancialTrackerLogic getFinancialTrackerLogic() {
        return this.financialTrackerLogic;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefsModel.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        userPrefsModel.setGuiSettings(guiSettings);
    }
}
