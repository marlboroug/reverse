package CCMASTER;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

	/*
	 * AES�ԳƼ��ܺͽ���
	 */
	public class SymmetricEncoder {
	  /*
	   * ����
	   * 1.������Կ������
	   * 2.����ecnodeRules�����ʼ����Կ������
	   * 3.������Կ
	   * 4.�����ͳ�ʼ��������
	   * 5.���ݼ���
	   * 6.�����ַ���
	   */
	    public static String AESEncode(String encodeRules,String content){
	        try {
	            //1.������Կ��������ָ��ΪAES�㷨,�����ִ�Сд
	            KeyGenerator keygen=KeyGenerator.getInstance("AES");
	            //2.����ecnodeRules�����ʼ����Կ������
	            //����һ��128λ�����Դ,���ݴ�����ֽ�����
	            keygen.init(128, new SecureRandom(encodeRules.getBytes()));
	              //3.����ԭʼ�Գ���Կ
	            SecretKey original_key=keygen.generateKey();
	              //4.���ԭʼ�Գ���Կ���ֽ�����
	            byte [] raw=original_key.getEncoded();
	            //5.�����ֽ���������AES��Կ
	            SecretKey key=new SecretKeySpec(raw, "AES");
	              //6.����ָ���㷨AES�Գ�������
	            Cipher cipher=Cipher.getInstance("AES");
	              //7.��ʼ������������һ������Ϊ����(Encrypt_mode)���߽��ܽ���(Decrypt_mode)�������ڶ�������Ϊʹ�õ�KEY
	            cipher.init(Cipher.ENCRYPT_MODE, key);
	            //8.��ȡ�������ݵ��ֽ�����(����Ҫ����Ϊutf-8)��Ȼ��������������ĺ�Ӣ�Ļ�����ľͻ����Ϊ����
	            byte [] byte_encode=content.getBytes("utf-8");
	            //9.�����������ĳ�ʼ����ʽ--���ܣ������ݼ���
	            byte [] byte_AES=cipher.doFinal(byte_encode);
	          //10.�����ܺ������ת��Ϊ�ַ���
	            //������Base64Encoder�л��Ҳ�����
	            //����취��
	            //����Ŀ��Build path�����Ƴ�JRE System Library������ӿ�JRE System Library�����±�����һ�������ˡ�
	            String AES_encode=new String(new BASE64Encoder().encode(byte_AES));
	          //11.���ַ�������
	            return AES_encode;
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        } catch (NoSuchPaddingException e) {
	            e.printStackTrace();
	        } catch (InvalidKeyException e) {
	            e.printStackTrace();
	        } catch (IllegalBlockSizeException e) {
	            e.printStackTrace();
	        } catch (BadPaddingException e) {
	            e.printStackTrace();
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        
	        //����д�ͷ���nulll
	        return null;         
	    }
	    /*
	     * ����
	     * ���ܹ��̣�
	     * 1.ͬ����1-4��
	     * 2.�����ܺ���ַ������ĳ�byte[]����
	     * 3.���������ݽ���
	     */
	    public static String AESDncode(String encodeRules,String content){
	        try {
	            //1.������Կ��������ָ��ΪAES�㷨,�����ִ�Сд
	            KeyGenerator keygen=KeyGenerator.getInstance("AES");
	            //2.����ecnodeRules�����ʼ����Կ������
	            //����һ��128λ�����Դ,���ݴ�����ֽ�����
	            keygen.init(128, new SecureRandom(encodeRules.getBytes()));
	              //3.����ԭʼ�Գ���Կ
	            SecretKey original_key=keygen.generateKey();
	              //4.���ԭʼ�Գ���Կ���ֽ�����
	            byte [] raw=original_key.getEncoded();
	            //5.�����ֽ���������AES��Կ
	            SecretKey key=new SecretKeySpec(raw, "AES");
	              //6.����ָ���㷨AES�Գ�������
	            Cipher cipher=Cipher.getInstance("AES");
	              //7.��ʼ������������һ������Ϊ����(Encrypt_mode)���߽���(Decrypt_mode)�������ڶ�������Ϊʹ�õ�KEY
	            cipher.init(Cipher.DECRYPT_MODE, key);
	            //8.�����ܲ����������ݽ�����ֽ�����
	            byte [] byte_content= new BASE64Decoder().decodeBuffer(content);
	            /*
	             * ����
	             */
	            byte [] byte_decode=cipher.doFinal(byte_content);
	            String AES_decode=new String(byte_decode,"utf-8");
	            return AES_decode;
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        } catch (NoSuchPaddingException e) {
	            e.printStackTrace();
	        } catch (InvalidKeyException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (IllegalBlockSizeException e) {
	            e.printStackTrace();
	        } catch (BadPaddingException e) {
	            e.printStackTrace();
	        }
	        
	        //����д�ͷ���nulll
	        return null;         
	    }
	    
	    public static void main(String[] args) {
	        SymmetricEncoder se=new SymmetricEncoder();
	        Scanner scanner=new Scanner(System.in);
	        /*
	         * ����
	         */
	        System.out.println("ʹ��AES�ԳƼ��ܣ���������ܵĹ���");
	        String encodeRules=scanner.nextLine();
	        System.out.println("������Ҫ���ܵ�����:");
	        String content = scanner.nextLine();
	        System.out.println("��������Ĺ���"+encodeRules+"���ܺ��������:"+se.AESEncode(encodeRules, content));
	       
	        /*
	         * ����
	         */
	        System.out.println("ʹ��AES�Գƽ��ܣ���������ܵĹ���(���������ͬ)");
	         encodeRules=scanner.nextLine();
	        System.out.println("������Ҫ���ܵ����ݣ����ģ�:");
	         content = scanner.nextLine();
	        System.out.println("��������Ĺ���"+encodeRules+"���ܺ��������:"+se.AESDncode(encodeRules, content));
	    }
}

