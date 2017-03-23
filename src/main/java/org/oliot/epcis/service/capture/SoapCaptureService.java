package org.oliot.epcis.service.capture;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;


//import org.oliot.epcis.axis.ObjectEventType;
import org.oliot.model.epcis.EPCISDocumentType;
import org.oliot.model.epcis.EPCISMasterDataDocumentType;
import org.oliot.model.epcis.ObjectEventType;

/**
 * Copyright (C) 2014 Jaewook Jack Byun
 *
 * This project is part of Oliot (oliot.org), pursuing the implementation of
 * Electronic Product Code Information Service(EPCIS) v1.1 specification in
 * EPCglobal.
 * [http://www.gs1.org/gsmp/kc/epcglobal/epcis/epcis_1_1-standard-20140520.pdf]
 * 
 *
 * @author Jaewook Jack Byun, Ph.D student
 * 
 *         Korea Advanced Institute of Science and Technology (KAIST)
 * 
 *         Real-time Embedded System Laboratory(RESL)
 * 
 *         bjw0829@kaist.ac.kr, bjw0829@gmail.com
 */
//@WebService注解让CXF知道我们希望使用哪个接口来创建WSDL
//@XmlSeeAlso({ObjectEventType.class})
//@WebService()

@WebService(endpointInterface = "org.oliot.epcis.service.capture.CoreCaptureService")

//@Stateless()
public class SoapCaptureService implements CoreCaptureService {

	@Override
	public void capture(EPCISDocumentType epcisDocument) {
		CaptureService cs = new CaptureService();
		cs.capture(epcisDocument);
	}

	@Override
	public void capture(EPCISMasterDataDocumentType epcisMasterDataDocument) {
		CaptureService cs = new CaptureService();
		cs.capture(epcisMasterDataDocument);
	}

}
