package com.jonvallet.micronaut.signing;

import org.junit.jupiter.api.Test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Base64;

public class SigningTest {

  @Test
  public void rsaSigningTest() throws Exception {
    // Generate RSA key pair
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    keyGen.initialize(2048);
    KeyPair keyPair = keyGen.generateKeyPair();

    // Message to be signed
    String message = "This is a test message";

    // Sign the message
    Signature signature = Signature.getInstance("SHA256withRSA");
    signature.initSign(keyPair.getPrivate());
    signature.update(message.getBytes());
    byte[] signatureBytes = signature.sign();

    // Encode signature to Base64 for easy handling
    String encodedSignature = Base64.getEncoder().encodeToString(signatureBytes);
    System.out.println("Signature: " + encodedSignature);

    // Verify the signature
    signature.initVerify(keyPair.getPublic());
    signature.update(message.getBytes());
    boolean isCorrect = signature.verify(Base64.getDecoder().decode(encodedSignature));
    System.out.println("Signature valid? " + isCorrect);
  }

  @Test
  public void eccSigningTest() throws Exception {
    // Generate RSA key pair
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
    keyGen.initialize(256);
    KeyPair keyPair = keyGen.generateKeyPair();

    // Message to be signed
    String message = "This is a test message";

    // Sign the message
    Signature signature = Signature.getInstance("SHA256withECDSA");
    signature.initSign(keyPair.getPrivate());
    signature.update(message.getBytes());
    byte[] signatureBytes = signature.sign();

    // Encode signature to Base64 for easy handling
    String encodedSignature = Base64.getEncoder().encodeToString(signatureBytes);
    System.out.println("Signature: " + encodedSignature);

    // Verify the signature
    signature.initVerify(keyPair.getPublic());
    signature.update(message.getBytes());
    boolean isCorrect = signature.verify(Base64.getDecoder().decode(encodedSignature));
    System.out.println("Signature valid? " + isCorrect);
  }
}