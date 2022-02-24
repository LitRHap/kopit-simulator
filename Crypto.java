import java.security.*;
import java.nio.charset.StandardCharsets;
class Crypto{
  public static String  getHash(String password){//String salt
    try{
    MessageDigest hornet = MessageDigest.getInstance("SHA-256");
    // hornet.update(salt.getBytes(StandardCharsets.US_ASCII));
    byte[] bytes = hornet.digest(password.getBytes(StandardCharsets.US_ASCII));
    String hash = new String(bytes, StandardCharsets.US_ASCII);
    return hash;
    }
    catch(NoSuchAlgorithmException e){
      return "aaaaaaaaaaaaaaaaa";
    }
  }
  // public static String Salt(){
  //   SecureRandom random = new SecureRandom();
  //   byte[] bytes = new byte[16];
  //   random.nextBytes(bytes);
  //   String salt = new String(bytes, StandardCharsets.US_ASCII);
  //   return salt;
  // }
}
