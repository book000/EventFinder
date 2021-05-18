package com.tomacheese.eventfinder;

public enum I18nMsgType {
    CommandArgumentRequired("Requires arguments. The argument can be one of the following: {0}"),
    CommandArgumentIncorrect("Incorrect arguments. The argument can be one of the following: {0}"),
    LoadedHideConfig("The hide settings have been loaded."),
    AddSingleHide("Added {0} to the hide condition."),
    AddMultipleHide("Added {0} hiding conditions."),
    SaveHideConfig("The hide settings have been saved."),
    RemoveSingleHide("Removed {0} to the hide condition."),
    RemoveMultipleHide("Removed {0} hiding conditions."),
    TooManyArguments("There are too many arguments."),
    ResetFilter("The filtering settings have been reset."),
    SetFilter("Filtering is now configured: {0}"),
    HidingConditionCount("There are {0} hidden conditions that have been set.");

    String defaultMessage;

    I18nMsgType(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
