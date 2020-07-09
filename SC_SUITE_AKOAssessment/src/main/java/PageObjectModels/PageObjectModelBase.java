package PageObjectModels;

import Utils.DataReader;

abstract class PageObjectModelBase {
    protected DataReader reader;

    public PageObjectModelBase() {
        reader = new DataReader();
    }
}