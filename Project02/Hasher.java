// interface for objects that provide
// hasher functionality.
public interface Hasher {
    public String getHashName();
    public String hash(String plain);
  }