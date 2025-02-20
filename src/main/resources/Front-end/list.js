document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8080/products/list')
        .then(response => response.json())
        .then(products => {
            const tbody = document.querySelector('#productTable tbody');
            tbody.innerHTML = '';

            products.forEach(product => {
                const row = document.createElement('tr');

                row.innerHTML = `
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>R$ ${product.price.toFixed(2)}</td>
                    <td>${product.description}</td>
                    <td class="actions">
                        <button class="edit" onclick="editProduct(${product.id})">Editar</button>
                        <button class="delete" onclick="deleteProduct(${product.id})">Excluir</button>
                    </td>
                `;

                tbody.appendChild(row);
            });
        })
        .catch(error => {
            console.error('Erro ao carregar produtos:', error);
        });
});

function deleteProduct(id) {
    if (confirm('Tem certeza que deseja excluir este produto?')) {
        fetch(`http://localhost:8080/products/delete/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                alert('Produto excluído com sucesso!');
                window.location.reload(); // Recarrega a página para atualizar a lista
            }
        })
        .catch(error => {
            console.error('Erro ao excluir o produto:', error);
        });
    }
}

function editProduct(id) {
    window.location.href = `form-edit.html?id=${id}`; // Redireciona para a página de edição
}