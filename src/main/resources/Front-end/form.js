document.getElementById('productForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const product = {
        name: document.getElementById('name').value,
        price: parseFloat(document.getElementById('price').value),
        description: document.getElementById('description').value
    };

    fetch('http://localhost:8080/products/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    })
    .then(response => response.json())
    .then(data => {
        alert('Produto salvo com sucesso!');
        window.location.href = 'list.html'; // Redireciona para a lista de produtos
    })
    .catch(error => {
        console.error('Erro ao salvar o produto:', error);
    });
});