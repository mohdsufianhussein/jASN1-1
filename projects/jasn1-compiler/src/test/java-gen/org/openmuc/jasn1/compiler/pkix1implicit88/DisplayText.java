/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.pkix1implicit88;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;

import org.openmuc.jasn1.compiler.pkix1explicit88.Attribute;
import org.openmuc.jasn1.compiler.pkix1explicit88.CertificateSerialNumber;
import org.openmuc.jasn1.compiler.pkix1explicit88.DirectoryString;
import org.openmuc.jasn1.compiler.pkix1explicit88.Name;
import org.openmuc.jasn1.compiler.pkix1explicit88.ORAddress;
import org.openmuc.jasn1.compiler.pkix1explicit88.RelativeDistinguishedName;

public class DisplayText implements Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	public BerIA5String ia5String = null;
	public BerVisibleString visibleString = null;
	public BerBMPString bmpString = null;
	public BerUTF8String utf8String = null;
	
	public DisplayText() {
	}

	public DisplayText(byte[] code) {
		this.code = code;
	}

	public DisplayText(BerIA5String ia5String, BerVisibleString visibleString, BerBMPString bmpString, BerUTF8String utf8String) {
		this.ia5String = ia5String;
		this.visibleString = visibleString;
		this.bmpString = bmpString;
		this.utf8String = utf8String;
	}

	public int encode(BerByteArrayOutputStream os) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;
		}

		int codeLength = 0;
		if (utf8String != null) {
			codeLength += utf8String.encode(os, true);
			return codeLength;
		}
		
		if (bmpString != null) {
			codeLength += bmpString.encode(os, true);
			return codeLength;
		}
		
		if (visibleString != null) {
			codeLength += visibleString.encode(os, true);
			return codeLength;
		}
		
		if (ia5String != null) {
			codeLength += ia5String.encode(os, true);
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int codeLength = 0;
		BerTag passedTag = berTag;

		if (berTag == null) {
			berTag = new BerTag();
			codeLength += berTag.decode(is);
		}

		if (berTag.equals(BerIA5String.tag)) {
			ia5String = new BerIA5String();
			codeLength += ia5String.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerVisibleString.tag)) {
			visibleString = new BerVisibleString();
			codeLength += visibleString.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerBMPString.tag)) {
			bmpString = new BerBMPString();
			codeLength += bmpString.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(BerUTF8String.tag)) {
			utf8String = new BerUTF8String();
			codeLength += utf8String.decode(is, false);
			return codeLength;
		}

		if (passedTag != null) {
			return 0;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (ia5String != null) {
			sb.append("ia5String: ").append(ia5String);
			return;
		}

		if (visibleString != null) {
			sb.append("visibleString: ").append(visibleString);
			return;
		}

		if (bmpString != null) {
			sb.append("bmpString: ").append(bmpString);
			return;
		}

		if (utf8String != null) {
			sb.append("utf8String: ").append(utf8String);
			return;
		}

		sb.append("<none>");
	}

}

