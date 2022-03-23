package model.resourceManagement;

import model.deviceManagement.Device;

public class SpecificDriver {
	
	public SpecificDriver() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Envia datos al DMA
	 * @param containerDma
	 */
	public void sendDataToDMA(byte[] containerDma) {
		
	}
	
	/**
	 * Leer salida estandar
	 * @param positionOuputStandar
	 * @return
	 */
	public byte[] readOuputStandar(int positionOuputStandar) {
		return null;
	}
	
	/**
	 * Obtener la disponibilidad del dispositivo
	 * @return
	 */
	public boolean getDisponibilityFromDevise(Device device) {
		return false;
	}
	
	/**
	 * Obtener recurso
	 */
	public void getResourse(Device device) {
		
	}
	
	// GENERAR INTERRUPCION
}