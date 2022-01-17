const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {photos: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/v1/photos'}).done(response => {
			this.setState({photos: response.entity._embedded.photoList});
		});
	}

	render() {
		return (
			<PhotoList photos={this.state.photos}/>
		)
	}
}

class PhotoList extends React.Component{
	render() {
		const photos = this.props.photos.map(photo =>
			<Photo key={photo._links.self.href} photo={photo}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Absolute Path</th>
						<th>Filename</th>
						<th>Status</th>
					</tr>
					{photos}
				</tbody>
			</table>
		)
	}
}

class Photo extends React.Component{
	render() {
		return (
			<tr>
				<td>
				    <img src={this.props.photo.absolutePath} alt={this.props.photo.filename}/>
				</td>
				<td>{this.props.photo.filename}</td>
				<td>{this.props.photo.status}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)