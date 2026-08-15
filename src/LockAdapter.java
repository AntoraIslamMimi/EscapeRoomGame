public class LockAdapter implements Lock {

    private LegacyLock legacyLock;

    public LockAdapter(LegacyLock legacyLock) {
        this.legacyLock = legacyLock;
    }

    public void unlock() {
        legacyLock.oldUnlockSystem();
    }
}