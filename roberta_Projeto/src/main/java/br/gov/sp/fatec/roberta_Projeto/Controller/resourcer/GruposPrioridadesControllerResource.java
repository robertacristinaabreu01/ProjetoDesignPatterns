package br.gov.sp.fatec.roberta_Projeto.Controller.resourcer;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import br.gov.sp.fatec.roberta_Projeto.domain.GruposPrioridades;
	import br.gov.sp.fatec.roberta_Projeto.repository.GruposPrioridadesRepository;

	@RestController
	@RequestMapping("/grupos-prioridades")
	public class GruposPrioridadesControllerResource {

		@Autowired
		private GruposPrioridadesRepository GruposPrioridadesRepository;

		@GetMapping
		public List<GruposPrioridades> listarTodos() {
			return GruposPrioridadesRepository.findAll();
		}

		@GetMapping("/{codigo}")
		public GruposPrioridades buscarPeloCodigo(@PathVariable Long codigo) {
			return GruposPrioridadesRepository.findById(codigo).orElse(null);
		}
	}
