package com.ceragem.api.base.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import com.ceragem.api.base.service.CrmCommonService;
import com.ceragem.api.config.jwt.EzJwtService;
import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPropertyServiceImpl;
import com.ceragem.crm.common.util.BaseUtilities;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * <pre>
 * com.ceragem.api.sys.util - Utilities.java
 * </pre>
 *
 * @ClassName : Utilities
 * @Description : 유틸리티
 * @author : 김성태
 * @date : 2021. 1. 5.
 * @Version : 1.0
 * @Company : Copyright ⓒ wigo.ai. All Right Reserved
 */
@Slf4j
@Component
public class Utilities extends BaseUtilities {
	private static final String _ENC_LANG = "UTF-8";

	private static final Validator _VALIDATOR;
	private static final SpringValidatorAdapter _VALIDATE_ADAPTER;

	private static final BarcodeFormat _BARCODE_FORMAT_COUPON;
	private static CrmCommonService commonService;
	private static EzPropertyServiceImpl propertiesService;
	@Autowired
	CrmCommonService commService;
	@Resource(name = "propertiesService")
	EzPropertyServiceImpl ezProperties;
	static {
		_VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
		_VALIDATE_ADAPTER = new SpringValidatorAdapter(_VALIDATOR);
		_BARCODE_FORMAT_COUPON = BarcodeFormat.CODE_128;
	}

	private Utilities() {

	}

	@PostConstruct
	public void init() throws Exception {
		super.init();
		commonService = this.commService;
		propertiesService = this.ezProperties;
	}

	public static Object validate(Object entry) throws BindException {
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(entry, entry.getClass().getName());
		_VALIDATE_ADAPTER.validate(entry, errors);
		if (errors == null || errors.getAllErrors().isEmpty())
			return entry;
		else {
			throw new BindException(errors);
		}
	}

	public static String getProperty(String name) {
		return propertiesService.getString(name, "");
	}

	public static int getPropertyInt(String name) {
		return propertiesService.getInt(name, 0);
	}

	public static long getPropertyLong(String name) {
		return propertiesService.getLong(name, 0);
	}

	public static double getPropertyDouble(String name) {
		return propertiesService.getDouble(name, 0);
	}

	public static double getPropertyFloat(String name) {
		return propertiesService.getFloat(name, 0);
	}

	public static boolean getPropertyBoolean(String name) {
		return propertiesService.getBoolean(name, false);
	}

	public static String getAutoSeq(String prefix) throws Exception {
		EzMap param = new EzMap();
		param.setString("prefix", prefix);
		return getAutoSeq(param);
	}

//	public static String getAutoSeq(String prefix, String suffix) throws Exception {
//		EzMap param = new EzMap();
//		param.setString("prefix", prefix);
//		param.setString("suffix", suffix);
//		return getAutoSeq(param);
//	}

	public static String getAutoSeq(Map<String, Object> param) throws Exception {
		return commonService.getAutoSeq(param);
	}

	public static String getFileCd() throws Exception {
		EzMap param = new EzMap();
		param.setString("prefix", "FCD");
		return getAutoSeq(param);
	}

	public static String getTimeStamp() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+09:00'", Locale.KOREAN);
		sf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		return sf.format(new Date());
	}

	public static String getSystemCd() {
		return EzJwtService.getSystemCd();
	}

	public static BufferedImage createBarcodeImage(String text, int width, int height) {
		return createBarcodeImage(text, width, height, true);
	}

	public static BufferedImage createBarcodeImage(String text, int width, int height, boolean hasText) {
		int wd = width;
		int ht = height;
		if (Utilities.isEmpty(text) || wd <= 0 || ht <= 0)
			return null;

		try {
//			텍스트 쓰기용 크기 
			int totalTextLineToadd = 20;
			if (hasText)
				ht -= totalTextLineToadd;
//			바코드 이미지
			ByteArrayInputStream bis = new ByteArrayInputStream(createBarcodeByte(text, wd, ht));
			final BufferedImage image = ImageIO.read(bis);
			if (!hasText)
				return image;
			BufferedImage outputImage = new BufferedImage(image.getWidth(), image.getHeight() + totalTextLineToadd,
					BufferedImage.TYPE_INT_ARGB);
			Graphics g = outputImage.getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, outputImage.getWidth(), outputImage.getHeight());
			g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);

			g.setFont(new Font("", Font.PLAIN, 18));
			Color textColor = Color.BLACK;

			FontMetrics fm = g.getFontMetrics();
			int startingYposition = ht;
			g.setColor(Color.WHITE);
			g.fillRect(150, startingYposition - 15, outputImage.getWidth() - 300, totalTextLineToadd + 25);

//			쿠폰번호 쓰기
			g.setColor(textColor);
			g.drawString(text, (outputImage.getWidth() / 2) - (fm.stringWidth(text) / 2), startingYposition);
			return outputImage;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EzApiException(e.getMessage(), e);
		}
	}

	public static byte[] createBarcodeByte(String text, int width, int height) {
		if (Utilities.isEmpty(text) || width <= 0 || height <= 0)
			return null;
		try {
			Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			Writer writer = new Code128Writer();
			BitMatrix bitMatrix = writer.encode(text, _BARCODE_FORMAT_COUPON, width, height);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);

			return byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}

	public static String encryptPassword(String pwd) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(pwd);
	}

	public static boolean passwordMatch(String input, String encoded) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(input, encoded);
	}

	public static String wget(String strUri, String strPost, String token, boolean json, String method,
			Map<String, String> header, int readTimeout) {
		BufferedReader br = null;
		OutputStreamWriter osw = null;
		String methd = method;
		try {
			URL url = new URL(strUri);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn == null)
				return "";
			conn.setDoOutput(true);
			conn.setConnectTimeout(2000);
			conn.setReadTimeout(readTimeout);
			conn.setUseCaches(false);
			if (strPost != null) {
				if (BaseUtilities.isEmpty(methd))
					methd = "POST";

				if (json)
					conn.setRequestProperty("Content-Type", "application/json;charset=" + _ENC_LANG);
				else
					conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + _ENC_LANG);
			} else {
				if (BaseUtilities.isEmpty(methd))
					methd = "GET";
				if (json)
					conn.setRequestProperty("Content-Type", "application/json;charset=" + _ENC_LANG);
				else
					conn.setRequestProperty("Content-Type", "text/plain");
			}
			conn.setRequestMethod(methd);
			if (BaseUtilities.isNotEmpty(token)) {
				conn.setRequestProperty("Authorization", "bearer " + token);
			}
			if (header != null) {
				for (String key : header.keySet()) {
					conn.setRequestProperty(key, header.get(key));
				}
			}

			if (strPost != null && strPost.length() > 0) {
				osw = new OutputStreamWriter(conn.getOutputStream(), _ENC_LANG);
				osw.write(strPost);
				osw.flush();
			}

			int responseCode = conn.getResponseCode();
			if (responseCode != HttpURLConnection.HTTP_OK)
				return "";

			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), _ENC_LANG));

			char[] buffer = new char[1024];
			StringBuffer sb = new StringBuffer();
			do {
				int nRead = br.read(buffer);
				if (nRead <= 0)
					break;

				sb.append(buffer, 0, nRead);
			} while (true);
//			 String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
//			 return sb.toString().replaceAll(match, "");
			return sb.toString().replace("​", "");
		} catch (Exception ex) {

			return "";
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (Exception ex) {
				log.debug(ex.getMessage());
			}
			try {
				if (osw != null)
					osw.close();
			} catch (Exception ex) {
				log.debug(ex.getMessage());
			}

		}
	}
}
