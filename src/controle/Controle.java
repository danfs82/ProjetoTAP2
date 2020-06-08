package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dados.GerenciadorServidor;
import entidades.Servidor;
import excecoes.ExcecaoEntrada;
import view.Janela;

public class Controle {

	// Classe que realiza o controle da interface e do registro

	private Janela janela;

	private GerenciadorServidor gerenciador = new GerenciadorServidor();

	private Servidor servidor = new Servidor();

	public Controle() {
		// Inicia os listeners dos itens do menu
		janela = new Janela();

		janela.menuIncluirIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuIncluir_actionPerformed(e);
			}
		});

		janela.menuExcluirMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuExcluirMatricula_actionPerformed(e);
			}
		});

		janela.menuExcluirNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuExcluirNome_actionPerformed(e);
			}
		});

		janela.menuAtualizarMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuAtualizarMatricula_actionPerformed(e);
			}
		});

		janela.menuAtualizarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuAtualizarNome_actionPerformed(e);
			}
		});

		janela.menuConsultarMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuConsultarMatricula_actionPerformed(e);
			}
		});

		janela.menuConsultarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuConsultarNome_actionPerformed(e);
			}
		});

		janela.menuSairSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuSairSair_actionPerformed(e);
			}
		});

		janela.menuPropriedadesCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPropriedadesCriar_actionPerformed(e);
			}
		});
		
		janela.menuPropriedadesQuantidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPropriedadesTamanhoQtd_actionPerformed(e);
			}
		});

		janela.menuPropriedadesEsvaziar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPropriedadesEsvaziar_actionPerformed(e);
			}
		});

		janela.menuListarTudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuListarTudo_actionPerformed(e);
			}
		});

	}

	public void executar() {
		janela.setVisible(true);
	}

	// Cada método abaixo trata das ações específicas a serem executadas nos itens
	// do menu
	void menuIncluir_actionPerformed(ActionEvent e) {
		
		try {
			janela.janelaCRUD(1, true, true, "INCLUSÃO");
	
			janela.jBOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBOkIncluir_actionPerformed(e);
				}
			});
	
			janela.jBVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBVoltar_actionPerformed(e);
				}
			});
	
			janela.jBLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBLimpar_actionPerformed(e);
				}
			});
		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}

	void menuExcluirMatricula_actionPerformed(ActionEvent e) {
		try {
			janela.janelaCRUD(2, true, false, "EXCLUIR (POR MATRÍCULA)");
	
			janela.jBOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBOkConsultar_actionPerformed(e, true, true);
				}
			});
	
			janela.jBVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBVoltar_actionPerformed(e);
				}
			});
	
			janela.jBLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBLimpar_actionPerformed(e);
				}
			});
		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
	}

	void menuExcluirNome_actionPerformed(ActionEvent e) {
		try {
			janela.janelaCRUD(2, false, true, "EXCLUIR (POR NOME)");
	
			janela.jBOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBOkConsultar_actionPerformed(e, false, true);
				}
			});
	
			janela.jBVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBVoltar_actionPerformed(e);
				}
			});
	
			janela.jBLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBLimpar_actionPerformed(e);
				}
			});
		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	void menuAtualizarMatricula_actionPerformed(ActionEvent e) {
		try {
			janela.janelaCRUD(3, true, false, "ATUALIZAR (POR MATRÍCULA)");
	
			janela.jBOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBOkAtualizar_actionPerformed(e, true);
				}
			});
	
			janela.jBVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBVoltar_actionPerformed(e);
				}
			});
	
			janela.jBLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBLimpar_actionPerformed(e);
				}
			});
		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	void menuAtualizarNome_actionPerformed(ActionEvent e) {
		try {
			janela.janelaCRUD(3, false, true, "ATUALIZAR (POR NOME)");
	
			janela.jBOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBOkAtualizar_actionPerformed(e, false);
				}
			});
	
			janela.jBVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBVoltar_actionPerformed(e);
				}
			});
	
			janela.jBLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBLimpar_actionPerformed(e);
				}
			});
		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	void menuConsultarMatricula_actionPerformed(ActionEvent e) {
		try {
			janela.janelaCRUD(4, true, false, "CONSULTAR (POR MATRÍCULA)");
	
			janela.jBOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBOkConsultar_actionPerformed(e, true, false);
				}
			});
	
			janela.jBVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBVoltar_actionPerformed(e);
				}
			});
	
			janela.jBLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBLimpar_actionPerformed(e);
				}
			});
		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	void menuConsultarNome_actionPerformed(ActionEvent e) {
		try {
			janela.janelaCRUD(4, false, true, "CONSULTAR (POR NOME)");
	
			janela.jBOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBOkConsultar_actionPerformed(e, false, false);
				}
			});
	
			janela.jBVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBVoltar_actionPerformed(e);
				}
			});
	
			janela.jBLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBLimpar_actionPerformed(e);
				}
			});
		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	void menuListarTudo_actionPerformed(ActionEvent e) {
		try {
			janela.janelaListar(gerenciador.listarTudo(), "LISTAR TUDO");
	
			janela.jBVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBVoltar_actionPerformed(e);
				}
			});
		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	void menuPropriedadesTamanhoQtd_actionPerformed(ActionEvent e) {
		try {
			String informacoes = gerenciador.informacoesQuantidade();
			janela.janelaPropriedades("Quantidade:", informacoes + " registros", "QUANTIDADE DE REGISTRO");
	
			janela.jBVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBVoltar_actionPerformed(e);
				}
			});
		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}

	void menuPropriedadesCriar_actionPerformed(ActionEvent e) {
		try {
			if (JOptionPane.showConfirmDialog(null, "Criar a tabela?", "AVISO",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (gerenciador.criar() == true) {
					JOptionPane.showMessageDialog(null, "Tabela criada com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Tabela não foi criada!");
				}
			}
		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	void menuPropriedadesEsvaziar_actionPerformed(ActionEvent e) {
		try {
			if (JOptionPane.showConfirmDialog(null, "Esvaziar a tabela?", "AVISO",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (gerenciador.zerar() == true) {
					JOptionPane.showMessageDialog(null, "Tabela zerada com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Tabela não foi zerada!");
				}
			}
		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	void menuSairSair_actionPerformed(ActionEvent e) {
		janela.setVisible(false);

	}

	void jBLimpar_actionPerformed(ActionEvent e) {
		limparCampos();
	}

	void jBOkIncluir_actionPerformed(ActionEvent e) {

		try {
			Servidor servidor = leituraServidor(true);

			if (servidor != null) {

				if (gerenciador.inserir(servidor)) {
					JOptionPane.showMessageDialog(null, "Registro inserido com sucesso.");
					limparCampos();
				} else {
					throw new ExcecaoEntrada("Registro não foi inserido.");
				}
			}
		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Digite número válido! (Até 6 dígitos)");
		}

	}

	void jBOkAlterar_actionPerformed(ActionEvent e, boolean opcao) {

		try {
			Servidor servidor = leituraServidor(false);

			if (servidor != null) {

				if (gerenciador.atualizar(servidor)) {
					JOptionPane.showMessageDialog(null, "Registro alterado com sucesso.");
					limparCampos();
					if (opcao == true) {
						menuAtualizarMatricula_actionPerformed(e);
					} else {

						menuAtualizarNome_actionPerformed(e);
					}
				} else {
					throw new ExcecaoEntrada("Registro não foi alterado.");
				}
			}
		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Digite número válido! (Até 6 dígitos)");
		}

	}

	void jBOkAtualizar_actionPerformed(ActionEvent e, boolean opcao) {

		try {
			int matricula;

			Servidor servidor;

			servidor = localizarServidor(opcao);
			matricula = servidor.getMatricula();

			janela.janelaCRUD(1, true, true, "ATUALIZAR");

			janela.jTMatricula.setText(Integer.toString(matricula));
			janela.jTNome.setText(servidor.getNome());
			janela.jTClasse.setText(Integer.toString(servidor.getClasse()));
			janela.jTSalario.setText(Double.toString(servidor.getSalario()));
			janela.jTSetor.setText(servidor.getSetor());
			janela.jTMatricula.setEditable(false);

			janela.getContentPane().repaint();
			if (opcao == true) {
				janela.jBOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jBOkAlterar_actionPerformed(e, true);
					}
				});
			} else {
				janela.jBOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jBOkAlterar_actionPerformed(e, false);
					}
				});
			}

			if (opcao == true) {
				janela.jBVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						menuAtualizarMatricula_actionPerformed(e);
					}
				});
			} else {
				janela.jBVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						menuAtualizarNome_actionPerformed(e);
					}
				});
			}
			janela.jBLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jBLimpar_actionPerformed(e);
				}
			});

		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Digite número válido!");
		}

	}

	void jBOkConsultar_actionPerformed(ActionEvent e, boolean porMatricula, boolean excluir) {

		try {
			int matricula;

			Servidor servidor;

			servidor = localizarServidor(porMatricula);
			matricula = servidor.getMatricula();

			janela.janelaCRUD(1, true, true, excluir == false ? "CONSULTA" : "EXCLUIR SERVIDOR ABAIXO?");

			janela.jTMatricula.setText(Integer.toString(matricula));
			janela.jTNome.setText(servidor.getNome());
			janela.jTClasse.setText(Integer.toString(servidor.getClasse()));
			janela.jTSalario.setText(Double.toString(servidor.getSalario()));
			janela.jTSetor.setText(servidor.getSetor());
			janela.jTMatricula.setEditable(false);
			janela.jTNome.setEditable(false);
			janela.jTClasse.setEditable(false);
			janela.jTSetor.setEditable(false);
			janela.jTSalario.setEditable(false);
			if (excluir == false) {
				janela.jBOk.setEnabled(false);
			}
			janela.jBLimpar.setEnabled(false);

			janela.getContentPane().repaint();

			if (excluir == false) {
				if (porMatricula == true) {

					janela.jBVoltar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							menuConsultarMatricula_actionPerformed(e);
						}
					});
				} else {
					janela.jBVoltar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							menuConsultarNome_actionPerformed(e);
						}
					});
				}
			} else {
				janela.jBOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (gerenciador.excluirMatricula(matricula)) {
							JOptionPane.showMessageDialog(null, "Servidor excluído.");
							if (porMatricula == true) {
								menuExcluirMatricula_actionPerformed(e);
							} else {
								menuExcluirNome_actionPerformed(e);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Registro não encontrado!");
						}
					}
				});
				if (porMatricula == true) {
					janela.jBVoltar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							menuExcluirMatricula_actionPerformed(e);
						}
					});
				} else {
					janela.jBVoltar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							menuExcluirNome_actionPerformed(e);
						}
					});
				}
			}

		} catch (ExcecaoEntrada ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Digite número válido!");
		}

	}

	private Servidor localizarServidor(boolean opcao) throws ExcecaoEntrada {

		int matricula;
		Servidor servidor;
		if (opcao == true) {

			matricula = (int) getNumero(janela.jTMatricula.getText(), 1, 999999,
					"Digite número de matrícula válido (até 6 dígitos)!");

			servidor = gerenciador.pesquisarMatricula(matricula);

			if (servidor == null) {
				throw new ExcecaoEntrada("Servidor não localizado!");
			}
		} else {
			String nome = getTexto(janela.jTNome.getText(), "Digite um nome válido!");

			servidor = gerenciador.pesquisarNome(nome);
			if (servidor != null) {
				matricula = servidor.getMatricula();
			} else {

				throw new ExcecaoEntrada("Servidor não localizado!");
			}
		}

		return servidor;
		

	}

	public Servidor leituraServidor(boolean checarDuplicidade) throws ExcecaoEntrada, NumberFormatException {
		// Método para registrar o objeto Servidor

		Integer matricula;
		String nome;
		String setor;
		Double salario;
		Integer classe;

		Servidor servidor = new Servidor();

		matricula = (int) getNumero(janela.jTMatricula.getText(), 1, 999999,
				"Digite número de matrícula válido (até 6 dígitos)!");
		if (checarDuplicidade == true) {
			Servidor servidorduplo = gerenciador.pesquisarMatricula(matricula);

			// Se servidorduplo != null encontrou o registro
			if (servidorduplo != null) {
				servidor = null;
				throw new ExcecaoEntrada("Servidor já existente no registro! \n" + servidorduplo.toString());
			}
		}

		servidor.setMatricula(matricula);
		nome = getTexto(janela.jTNome.getText(), "Digite nome válido!");
		servidor.setNome(nome);
		setor = getTexto(janela.jTSetor.getText(), "Digite setor válido!");
		servidor.setSetor(setor);
		salario = getNumero(janela.jTSalario.getText(), 0.0, 40000.0,
				"Digite salário válido (de R$ 0,00 a R$ 40.000,00 !");
		servidor.setSalario(salario);
		classe = (int) getNumero(janela.jTClasse.getText(), 1, 13, "Digite uma classe válida (1 a 13)");
		servidor.setClasse(classe);

		return servidor;
	}

	void jBVoltar_actionPerformed(ActionEvent e) {
		janela.limparPainel();
		janela.getContentPane().repaint();
	}

	public double getNumero(String auxiliarString, double min, double max, String errorMsg)
			throws ExcecaoEntrada, NumberFormatException {

		// Método para tratar de valores numéricos de entrada

		double auxiliarDouble;

		if (auxiliarString == null) {
			throw new ExcecaoEntrada(errorMsg);
		}

		auxiliarString = auxiliarString.trim();

		if (!eNumerico(auxiliarString)) {

			throw new ExcecaoEntrada(errorMsg);

		} else {

			auxiliarDouble = Double.parseDouble(auxiliarString);

			if (auxiliarDouble < min || auxiliarDouble > max) {

				throw new ExcecaoEntrada(errorMsg);
			} else {

				return Double.parseDouble(auxiliarString);
			}
		}
	}

	public static boolean eNumerico(String texto) {
		// Verifica se o texto tem valor numérico
		try {
			double d = Double.parseDouble(texto);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public String getTexto(String auxiliarString, String msgErro) {
		// Solicita ao usuário uma entrada em texto

		if (auxiliarString == null) {
			throw new ExcecaoEntrada(msgErro);
		} else {

			auxiliarString = auxiliarString.trim();

			if (auxiliarString.equals("")) {
				throw new ExcecaoEntrada(msgErro);
			}

		}

		return auxiliarString;
	}

	public void limparCampos() {

		janela.jTMatricula.setText("");
		janela.jTNome.setText("");
		janela.jTSetor.setText("");
		janela.jTSalario.setText("");
		janela.jTClasse.setText("");
	}
	

}
