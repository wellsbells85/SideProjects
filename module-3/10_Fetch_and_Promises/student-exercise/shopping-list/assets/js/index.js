document.addEventListener('DOMContentLoaded', () => {
    const listURL = 'https://techelevator-pgh-teams.azurewebsites.net/api/techelevator/shoppinglist';
    const btnLoadList = document.querySelector('.loadingButton');
    const template = document.getElementById('shopping-list-item-template');
    const ul = document.querySelector('ul');
    btnLoadList.addEventListener('click', () => {
        fetch(listURL) 
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            ul.innerText = '';
            data.forEach((item) => {
                const clone = template.content.cloneNode(true);
                const li = clone.querySelector('li');
                const i = clone.querySelector('i');
                const complete = item.completed;
                if(complete) {
                    i.classList.add('completed');
                }
                li.innerText = item.name;
                li.append(i);
                ul.append(clone);
            });
        })
        .catch((err) => {
            console.error(err);
        });
    }); //end btnLoadList.addEventListener
}); //end document.addEventListener
