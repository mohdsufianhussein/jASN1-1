/**
 * This class file was automatically generated by jASN1 v1.6.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.someexamples.generated.pkix1implicit88;

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

import org.openmuc.jasn1.compiler.someexamples.generated.rspdefinitions.*;
import org.openmuc.jasn1.compiler.someexamples.generated.pkix1explicit88.*;

public class IssuingDistributionPoint {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public DistributionPointName distributionPoint = null;

	public BerBoolean onlyContainsUserCerts = null;

	public BerBoolean onlyContainsCACerts = null;

	public ReasonFlags onlySomeReasons = null;

	public BerBoolean indirectCRL = null;

	public BerBoolean onlyContainsAttributeCerts = null;

	public IssuingDistributionPoint() {
		id = identifier;
	}

	public IssuingDistributionPoint(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public IssuingDistributionPoint(DistributionPointName distributionPoint, BerBoolean onlyContainsUserCerts, BerBoolean onlyContainsCACerts, ReasonFlags onlySomeReasons, BerBoolean indirectCRL, BerBoolean onlyContainsAttributeCerts) {
		id = identifier;
		this.distributionPoint = distributionPoint;
		this.onlyContainsUserCerts = onlyContainsUserCerts;
		this.onlyContainsCACerts = onlyContainsCACerts;
		this.onlySomeReasons = onlySomeReasons;
		this.indirectCRL = indirectCRL;
		this.onlyContainsAttributeCerts = onlyContainsAttributeCerts;
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
			int sublength;

			if (onlyContainsAttributeCerts != null) {
				codeLength += onlyContainsAttributeCerts.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 5
				os.write(0x85);
				codeLength += 1;
			}
			
			if (indirectCRL != null) {
				codeLength += indirectCRL.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 4
				os.write(0x84);
				codeLength += 1;
			}
			
			if (onlySomeReasons != null) {
				codeLength += onlySomeReasons.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 3
				os.write(0x83);
				codeLength += 1;
			}
			
			if (onlyContainsCACerts != null) {
				codeLength += onlyContainsCACerts.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 2
				os.write(0x82);
				codeLength += 1;
			}
			
			if (onlyContainsUserCerts != null) {
				codeLength += onlyContainsUserCerts.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 1
				os.write(0x81);
				codeLength += 1;
			}
			
			if (distributionPoint != null) {
				sublength = distributionPoint.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
				os.write(0xa0);
				codeLength += 1;
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
		codeLength += totalLength;

		if (totalLength == -1) {
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
				subCodeLength += length.decode(is);
				distributionPoint = new DistributionPointName();
				int choiceDecodeLength = distributionPoint.decode(is, null);
				if (choiceDecodeLength != 0) {
					subCodeLength += choiceDecodeLength;
					subCodeLength += berIdentifier.decode(is);
				}
				else {
					distributionPoint = null;
				}

			}
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
				onlyContainsUserCerts = new BerBoolean();
				subCodeLength += onlyContainsUserCerts.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
				onlyContainsCACerts = new BerBoolean();
				subCodeLength += onlyContainsCACerts.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
				onlySomeReasons = new ReasonFlags();
				subCodeLength += onlySomeReasons.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 4)) {
				indirectCRL = new BerBoolean();
				subCodeLength += indirectCRL.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 5)) {
				onlyContainsAttributeCerts = new BerBoolean();
				subCodeLength += onlyContainsAttributeCerts.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			int nextByte = is.read();
			if (berIdentifier.tagNumber != 0 || berIdentifier.identifierClass != 0 || berIdentifier.primitive != 0
			|| nextByte != 0) {
				if (nextByte == -1) {
					throw new EOFException("Unexpected end of input stream.");
				}
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			codeLength += subCodeLength + 1;
			return codeLength;
		}

		if (totalLength == 0) {
			return codeLength;
		}
		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			subCodeLength += length.decode(is);
			distributionPoint = new DistributionPointName();
			subCodeLength += distributionPoint.decode(is, null);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			onlyContainsUserCerts = new BerBoolean();
			subCodeLength += onlyContainsUserCerts.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
			onlyContainsCACerts = new BerBoolean();
			subCodeLength += onlyContainsCACerts.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
			onlySomeReasons = new ReasonFlags();
			subCodeLength += onlySomeReasons.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 4)) {
			indirectCRL = new BerBoolean();
			subCodeLength += indirectCRL.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 5)) {
			onlyContainsAttributeCerts = new BerBoolean();
			subCodeLength += onlyContainsAttributeCerts.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		boolean firstSelectedElement = true;
		if (distributionPoint != null) {
			sb.append("distributionPoint: ").append(distributionPoint);
			firstSelectedElement = false;
		}
		
		if (onlyContainsUserCerts != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("onlyContainsUserCerts: ").append(onlyContainsUserCerts);
			firstSelectedElement = false;
		}
		
		if (onlyContainsCACerts != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("onlyContainsCACerts: ").append(onlyContainsCACerts);
			firstSelectedElement = false;
		}
		
		if (onlySomeReasons != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("onlySomeReasons: ").append(onlySomeReasons);
			firstSelectedElement = false;
		}
		
		if (indirectCRL != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("indirectCRL: ").append(indirectCRL);
			firstSelectedElement = false;
		}
		
		if (onlyContainsAttributeCerts != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("onlyContainsAttributeCerts: ").append(onlyContainsAttributeCerts);
			firstSelectedElement = false;
		}
		
		sb.append("}");
		return sb.toString();
	}

}

