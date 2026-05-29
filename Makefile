# ==============================================================================
# Makefile
# Uso: make <alvo>
# ==============================================================================

.PHONY: help setup up down restart logs shell seed status

help:
	@echo ""
	@echo "  Comandos disponíveis:"
	@echo ""
	@echo "  make up s=<serviço> n=<serviço>   	-> Sobe todos ou um serviço específico, ou, sobe todos os serviços exceto <n>"
	@echo "  make down      					-> Derruba todos os serviços"
	@echo "  make restart s=<svc>  				-> Reinicia todos ou um serviço específico"
	@echo "  make logs      					-> Exibe logs em tempo real de todos os serviços"
	@echo "  make status    					-> Exibe o status dos containers"
	@echo "  make shell s=<serviço> 			-> Acessa o shell de um serviço específico (ex: s=app)"
	@echo "  make clean	 						-> Derruba os serviços e remove volumes (CUIDADO: apaga o banco)"
	@echo ""

up:
	@if [ -n "$(s)" ]; then \
		echo "🚀 Subindo serviço $(s)..."; \
		docker compose up --build $(s); \
	elif [ -n "$(n)" ]; then \
		echo "🚀 Subindo todos os serviços, exceto: $(n)..."; \
		EXCLUDE_PATTERN=$$(echo "$(n)" | tr ' ' '|'); \
		docker compose up -d --build $$(docker compose config --services | grep -v $(n)); \
	else \
		echo "🚀 Subindo todos os serviços..."; \
		docker compose up -d --build; \
	fi
	@echo "✅ Template no ar. Verifique o status com 'make status'."

down:
	@if [ -n "$(s)" ]; then \
		echo "🛑 Derrubando serviço $(s)..."; \
		docker compose down $(s); \
		echo "✅ Serviço $(s) encerrado." \
	else \
		echo "🛑 Derrubando os serviços..."; \
		docker compose down; \
		echo "✅ Serviços encerrados." \
	fi

restart:
	@if [ -n "$(s)" ]; then \
		echo "🔄 Reiniciando serviço $(s)..."; \
		docker compose restart $(s); \
	else \
		echo "🔄 Reiniciando todos os serviços..."; \
		docker compose restart; \
	fi

logs:
	@if [ -n "$(s)" ]; then \
		docker compose logs $(s) -f; \
	else \
		docker compose logs -f; \
	fi

status:
	docker compose ps --format "table {{.ID}}\t{{.Name}}\t{{.Status}}\t{{.Image}}"

shell:
	@if [ -z "$(s)" ]; then \
		echo "❌ Por favor, especifique o serviço com 's=<serviço>' (ex: make shell s=app)"; \
		exit 1; \
	fi
	docker compose exec $(s) sh || docker compose exec $(s) bash

clean:
	@echo "⚠️ CUIDADO: Isso irá remover todos os volumes, incluindo o banco de dados."
	@read -p "Tem certeza que deseja continuar? (s/N) " confirm && [ "$$confirm" = "s" ] || exit 1
	docker compose down -v
	@echo "✅ Serviços derrubados e volumes removidos."