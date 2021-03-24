package br.gov.sp.fatec.roberta_Projeto.Controller.resourcer;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import br.gov.sp.fatec.roberta_Projeto.domain.GruposPrioridades;
	import br.gov.sp.fatec.roberta_Projeto.repository.GruposPrioridadesRepository;

	@RestController
	@RequestMapping("/pessoas")
	public class GruposPrioridadesControllerResource {

		@Autowired
		private GruposPrioridadesRepository GruposPrioridadesRepository;

		@GetMapping
		public List<GruposPrioridades> listarTodos() {
			return GruposPrioridadesRepository.findAll();
		}

		@PostMapping
		public GruposPrioridades cadastrarPessoa(@RequestBody GruposPrioridades GruposPrioridades) {
			return GruposPrioridadesRepository.save(GruposPrioridades);
		}

		@PutMapping("/{codigo}")
		public GruposPrioridades atualizar(@PathVariable("codigo") Long codigo, @RequestBody GruposPrioridades GruposPrioridades) {
			return GruposPrioridadesRepository.findById(codigo).map(record -> {
				record.setCodigo(GruposPrioridades.getCodigo());
				record.setDescricao(GruposPrioridades.getDescricao());
				record.setNome(GruposPrioridades.getNome());
				return GruposPrioridadesRepository.save(record);
			}).orElse(null);
		}

		@GetMapping("/{codigo}")
		public GruposPrioridades buscarPeloCodigo(@PathVariable Long codigo) {
			return GruposPrioridadesRepository.findById(codigo).orElse(null);
		}
	}

