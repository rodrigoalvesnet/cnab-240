package richard.cnab240.modelo.registro.header.servico;

import richard.cnab240.modelo.enums.TipoRegistro;
import richard.cnab240.modelo.enums.TipoServico;
import richard.cnab240.modelo.pojo.Controle;
import richard.cnab240.modelo.pojo.ControleDeVendor;
import richard.cnab240.modelo.pojo.Empresa2;
import richard.cnab240.modelo.pojo.Servico5;
import richard.cnab240.modelo.registro.header.HeaderLote;
import richard.cnab240.util.ArquivoUtils;

public class HeaderLoteVendor extends HeaderLote {
	private Controle controle;
	private Servico5 servico;
	private String campoExclusivoCNAB1;
	private Empresa2 empresa;
	private ControleDeVendor controleDeVendor;
	private String campoExclusivoCNAB2;

	public HeaderLoteVendor() {
		setControle(new Controle());
		getControle().setTipoRegistro(TipoRegistro.HEADER_DE_LOTE);
		setServico(new Servico5());
		getServico().setNumeroVersaoLayoutLote(12);
		// getServico().setTipoOperacao(TipoOperacao.ARQUIVO_REMESSA || TipoOperacao.ARQUIVO_RETORNO);
		getServico().setTipoServico(TipoServico.VENDOR);
		setCampoExclusivoCNAB1(ArquivoUtils.BRANCO);
		setControleDeVendor(new ControleDeVendor());
		setCampoExclusivoCNAB2(ArquivoUtils.BRANCO);
	}

	public Controle getControle() {
		return controle;
	}

	public void setControle(Controle controle) {
		this.controle = controle;
	}

	public Servico5 getServico() {
		return servico;
	}

	public void setServico(Servico5 servico) {
		this.servico = servico;
	}

	public String getCampoExclusivoCNAB1() {
		return campoExclusivoCNAB1;
	}

	public void setCampoExclusivoCNAB1(String campoExclusivoCNAB1) {
		this.campoExclusivoCNAB1 = campoExclusivoCNAB1;
	}

	public Empresa2 getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa2 empresa) {
		this.empresa = empresa;
	}

	public ControleDeVendor getControleDeVendor() {
		return controleDeVendor;
	}

	public void setControleDeVendor(ControleDeVendor controleDeVendor) {
		this.controleDeVendor = controleDeVendor;
	}

	public String getCampoExclusivoCNAB2() {
		return campoExclusivoCNAB2;
	}

	public void setCampoExclusivoCNAB2(String campoExclusivoCNAB2) {
		this.campoExclusivoCNAB2 = campoExclusivoCNAB2;
	}

	@Override
	public String getConteudoRegistro() {
		StringBuilder sb = new StringBuilder(TAMANHO_REGISTRO);
		sb.append(getControle().toString());
		sb.append(getServico().toString());
		sb.append(ArquivoUtils.getCampoAlfaNumerico(getCampoExclusivoCNAB1(), 1));
		sb.append(getEmpresa().toString());
		sb.append(getControleDeVendor().toString());
		sb.append(ArquivoUtils.getCampoAlfaNumerico(getCampoExclusivoCNAB2(), 122));
		
		return sb.toString();
	}

}