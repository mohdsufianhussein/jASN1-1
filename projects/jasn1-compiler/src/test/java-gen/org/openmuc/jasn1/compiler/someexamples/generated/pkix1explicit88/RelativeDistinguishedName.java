/**
 * This class file was automatically generated by jASN1 v1.6.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.someexamples.generated.pkix1explicit88;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;

import org.openmuc.jasn1.compiler.someexamples.generated.pkix1implicit88.*;
import org.openmuc.jasn1.compiler.someexamples.generated.rspdefinitions.*;

public class RelativeDistinguishedName {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 17);
	protected BerIdentifier id;

	public byte[] code = null;
	public List<AttributeTypeAndValue> seqOf = null;

	public RelativeDistinguishedName() {
		id = identifier;
		seqOf = new ArrayList<AttributeTypeAndValue>();
	}

	public RelativeDistinguishedName(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public RelativeDistinguishedName(List<AttributeTypeAndValue> seqOf) {
		id = identifier;
		this.seqOf = seqOf;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		int codeLength;

		if (code != null) {
			codeLength = code.length;
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
		}
		else {
			codeLength = 0;
			for (int i = (seqOf.size() - 1); i >= 0; i--) {
				codeLength += seqOf.get(i).encode(os, true);
			}

			codeLength += BerLength.encodeLength(os, codeLength);

		}

		if (explicit) {
			codeLength += id.encode(os);
		}

		return codeLength;
	}

	public int decode(InputStream is, boolean explicit) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerIdentifier berIdentifier = new BerIdentifier();
		if (explicit) {
			codeLength += id.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);
		int totalLength = length.val;

		if (length.val == -1) {
			while (true) {
				subCodeLength += berIdentifier.decode(is);

				if (berIdentifier.tagNumber == 0 && berIdentifier.identifierClass == 0 && berIdentifier.primitive == 0) {
					int nextByte = is.read();
					if (nextByte != 0) {
						if (nextByte == -1) {
							throw new EOFException("Unexpected end of input stream.");
						}
						throw new IOException("Decoded sequence has wrong end of contents octets");
					}
					codeLength += subCodeLength + 1;
					return codeLength;
				}

				AttributeTypeAndValue element = new AttributeTypeAndValue();
				subCodeLength += element.decode(is, false);
				seqOf.add(element);
			}
		}
		while (subCodeLength < totalLength) {
			AttributeTypeAndValue element = new AttributeTypeAndValue();
			subCodeLength += element.decode(is, true);
			seqOf.add(element);
		}
		if (subCodeLength != totalLength) {
			throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

		}
		codeLength += subCodeLength;

		return codeLength;
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE OF{");

		if (seqOf == null) {
			sb.append("null");
		}
		else {
			Iterator<AttributeTypeAndValue> it = seqOf.iterator();
			if (it.hasNext()) {
				sb.append(it.next());
				while (it.hasNext()) {
					sb.append(", ").append(it.next());
				}
			}
		}

		sb.append("}");

		return sb.toString();
	}

}

