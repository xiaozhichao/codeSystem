package com.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

/**
 * RSA�㷨������
 * 
 * @author thinkpad
 *
 */
public class RSAUtil {

	private static final Integer RSB_KEY_SIZE = Integer.valueOf(PropertiesUtil.getValue("RSB_KEY_SIZE"));

	/**
	 * �����ܳ׶�
	 */
	public static KeyPair generateKeyPair() throws Exception {
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA",
					new org.bouncycastle.jce.provider.BouncyCastleProvider());
			keyPairGen.initialize(RSB_KEY_SIZE, new SecureRandom());
			KeyPair keyPair = keyPairGen.generateKeyPair();
			saveKeyPair(keyPair);
			return keyPair;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static KeyPair getKeyPair() throws Exception {
		FileInputStream fis = new FileInputStream("C:/RSAKey.txt");
		ObjectInputStream oos = new ObjectInputStream(fis);
		KeyPair kp = (KeyPair) oos.readObject();
		oos.close();
		fis.close();
		return kp;
	}

	public static void saveKeyPair(KeyPair kp) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/RSAKey.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// ������Կ
		oos.writeObject(kp);
		oos.close();
		fos.close();
	}

	/**
	 * * ���ɹ�Կ *
	 * 
	 * @param modulus
	 *            *
	 * @param publicExponent
	 *            *
	 * @return RSAPublicKey *
	 * @throws Exception
	 */
	public static RSAPublicKey generateRSAPublicKey(byte[] modulus, byte[] publicExponent) throws Exception {
		KeyFactory keyFac = null;
		try {
			keyFac = KeyFactory.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
		} catch (NoSuchAlgorithmException ex) {
			throw new Exception(ex.getMessage());
		}

		RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(modulus), new BigInteger(publicExponent));
		try {
			return (RSAPublicKey) keyFac.generatePublic(pubKeySpec);
		} catch (InvalidKeySpecException ex) {
			throw new Exception(ex.getMessage());
		}
	}

	/**
	 * * ����˽Կ *
	 * 
	 * @param modulus
	 *            *
	 * @param privateExponent
	 *            *
	 * @return RSAPrivateKey *
	 * @throws Exception
	 */
	public static RSAPrivateKey generateRSAPrivateKey(byte[] modulus, byte[] privateExponent) throws Exception {
		KeyFactory keyFac = null;
		try {
			keyFac = KeyFactory.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
		} catch (NoSuchAlgorithmException ex) {
			throw new Exception(ex.getMessage());
		}

		RSAPrivateKeySpec priKeySpec = new RSAPrivateKeySpec(new BigInteger(modulus), new BigInteger(privateExponent));
		try {
			return (RSAPrivateKey) keyFac.generatePrivate(priKeySpec);
		} catch (InvalidKeySpecException ex) {
			throw new Exception(ex.getMessage());
		}
	}

	/**
	 * 
	 * @param pk
	 *            ���ܵ���Կ
	 * @param data
	 *            �����ܵ���������
	 * @return ���ܺ������
	 * @throws Exception
	 */
	public static byte[] encrypt(PublicKey pk, byte[] data) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
			cipher.init(Cipher.ENCRYPT_MODE, pk);
			int blockSize = cipher.getBlockSize();// ��ü��ܿ��С���磺����ǰ����Ϊ128��byte����key_size=1024
			// ���ܿ��СΪ127
			// byte,���ܺ�Ϊ128��byte;��˹���2�����ܿ飬��һ��127
			// byte�ڶ���Ϊ1��byte
			int outputSize = cipher.getOutputSize(data.length);// ��ü��ܿ���ܺ���С
			int leavedSize = data.length % blockSize;
			int blocksSize = leavedSize != 0 ? data.length / blockSize + 1 : data.length / blockSize;
			byte[] raw = new byte[outputSize * blocksSize];
			int i = 0;
			while (data.length - i * blockSize > 0) {
				if (data.length - i * blockSize > blockSize)
					cipher.doFinal(data, i * blockSize, blockSize, raw, i * outputSize);
				else
					cipher.doFinal(data, i * blockSize, data.length - i * blockSize, raw, i * outputSize);
				// ������doUpdate���������ã��鿴Դ�������ÿ��doUpdate��û��ʲôʵ�ʶ������˰�byte[]�ŵ�
				// ByteArrayOutputStream�У������doFinal��ʱ��Ž����е�byte[]���м��ܣ����ǵ��˴�ʱ���ܿ��С�ܿ����Ѿ�������
				// OutputSize����ֻ����dofinal������

				i++;
			}
			return raw;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * @param pk
	 *            ���ܵ���Կ
	 * @param raw
	 *            �Ѿ����ܵ�����
	 * @return ���ܺ������
	 * @throws Exception
	 */
	public static byte[] decrypt(PrivateKey pk, byte[] raw) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
			cipher.init(cipher.DECRYPT_MODE, pk);
			int blockSize = cipher.getBlockSize();
			ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
			int j = 0;

			while (raw.length - j * blockSize > 0) {
				bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
				j++;
			}
			return bout.toByteArray();
		} catch (Exception e) {
			throw e;
		}

	}

	public static void main(String[] args) {
		
		try {
			RSAPublicKey rsap = (RSAPublicKey)generateKeyPair().getPublic();
			String test = "hello world";
			byte[] en_test;
			en_test = encrypt(getKeyPair().getPublic(), test.getBytes());
			System.out.println(new String(en_test));
			byte[] de_test = decrypt(getKeyPair().getPrivate(), en_test);
			System.out.println(new String(de_test));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
